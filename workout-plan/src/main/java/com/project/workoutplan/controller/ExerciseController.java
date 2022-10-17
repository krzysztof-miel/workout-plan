package com.project.workoutplan.controller;

import com.project.workoutplan.data.Exercise;
import com.project.workoutplan.error.ExerciseNotFoundException;
import com.project.workoutplan.service.ExerciseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/exercises")
public class ExerciseController {

    private final Logger logger = LoggerFactory.getLogger(ExerciseController.class);

    private ExerciseService service;

    public ExerciseController(ExerciseService service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<Exercise> saveExercise(@Valid @RequestBody Exercise toCreate) {
        logger.info("Log inside saveExercise from Exercise Controller");
        Exercise exercise = service.saveExercise(toCreate);
        return ResponseEntity.created(URI.create("/" + exercise.getId())).body(exercise);
    }

    @GetMapping("")
    public ResponseEntity<List<Exercise>> readAllExercises(){
        logger.info("Log inside readAllExercises from Exercise Controller");
        return ResponseEntity.ok(service.readAllExercises());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Exercise> getById(@PathVariable("id") int id) throws ExerciseNotFoundException {
        logger.info("Log inside getById from Exercise Controller");
        return ResponseEntity.ok(service.getById(id));
    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteById(@PathVariable ("id") int id) throws ExerciseNotFoundException {
        logger.info("Log inside deleteById from Exercise Controller");
        service.getById(id);
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> updateExerciseName(@PathVariable ("id") int id,
                                            @RequestBody Exercise exercise) throws ExerciseNotFoundException {
        logger.info("Log inside updateExerciseName from Exercise Controller");
        return ResponseEntity.ok(service.updateExerciseName(id, exercise));

    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<?> toggleExerciseDone(@PathVariable ("id") int id) throws ExerciseNotFoundException {
        logger.info("Log inside toggleExerciseDone from Exercise Controller");
        return ResponseEntity.ok(service.toggleExerciseDone(id, service.getById(id)));

    }


}
