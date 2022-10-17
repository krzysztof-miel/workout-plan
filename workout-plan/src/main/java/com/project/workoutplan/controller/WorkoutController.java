package com.project.workoutplan.controller;

import com.project.workoutplan.data.Exercise;
import com.project.workoutplan.projection.WorkoutReadModel;
import com.project.workoutplan.projection.WorkoutWriteModel;
import com.project.workoutplan.service.ExerciseService;
import com.project.workoutplan.service.WorkoutService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class WorkoutController {

    private final Logger logger = LoggerFactory.getLogger(WorkoutController.class);

    private WorkoutService service;
    private ExerciseService exerciseService;

    public WorkoutController(WorkoutService service, ExerciseService exerciseService) {
        this.service = service;
        this.exerciseService = exerciseService;
    }

    @PostMapping("/workouts")
    public ResponseEntity<WorkoutReadModel> saveWorkout(@Valid @RequestBody WorkoutWriteModel toCreate) {
        logger.info("Log inside saveWorkout from Workout Controller");
        WorkoutReadModel result = service.createWorkout(toCreate);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @ResponseBody
    @GetMapping(path = "/workouts")
    public ResponseEntity<List<WorkoutReadModel>> readAllWorkouts(){
        logger.info("Log inside readAllWorkouts from Workout Controller");
        return ResponseEntity.ok(service.readAll());
    }

    @ResponseBody
    @GetMapping(path = "/workouts/{id}")
    public ResponseEntity<List<Exercise>> getAllExercisesFromWorkoutById(@PathVariable("id") int id) throws Exception {
        logger.info("Log inside getById from Workout Controller");
        return ResponseEntity.ok(service.findAllExercisesByWorkout_Id(id));
    }

    @ResponseBody
    @PatchMapping(path = "/workouts/{id}")
    public ResponseEntity setWorkoutsExerciseToUndone(@PathVariable("id") int id) throws Exception {
        logger.info("Log inside setExerciseToUndone from Workout Controller");
        return ResponseEntity.ok(service.setWorkoutsExerciseToUndone(id));
    }
}
