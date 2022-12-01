package com.project.workoutplan.controller;

import com.project.workoutplan.data.Exercise;
import com.project.workoutplan.projection.ExerciseWriteModel;
import com.project.workoutplan.projection.WorkoutReadModel;
import com.project.workoutplan.projection.WorkoutWriteModel;
import com.project.workoutplan.service.ExerciseService;
import com.project.workoutplan.service.WorkoutService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/workouts")
public class WorkoutController {

    private final Logger logger = LoggerFactory.getLogger(WorkoutController.class);

    private WorkoutService service;
    private ExerciseService exerciseService;

    public WorkoutController(WorkoutService service, ExerciseService exerciseService) {
        this.service = service;
        this.exerciseService = exerciseService;
    }

    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    String showWorkouts(Model model) {
        model.addAttribute("workout", new WorkoutWriteModel());
        return "workouts";
    }

    @PostMapping(produces = MediaType.TEXT_HTML_VALUE, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    String addWorkout(
            @ModelAttribute("workout") @Valid WorkoutWriteModel current,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()){
            return "workouts";
        }
        service.createWorkout(current);
        model.addAttribute("workout", new WorkoutWriteModel());
        model.addAttribute("workouts", getWorkouts());
        model.addAttribute("message", "Workout plan added");
        return "workouts";
    }

    @PostMapping(params = "addExercise", produces = MediaType.TEXT_HTML_VALUE)
    String addExerciseToWorkout(@ModelAttribute("workout") WorkoutWriteModel current) {
        logger.info("Log inside addExerciseToWorkout from Workout Controller");
        current.getExercises().add(new ExerciseWriteModel());
        return "workouts";
    }

    @ResponseBody
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Exercise>> getAllExercisesFromWorkoutById(@PathVariable("id") int id) throws Exception {
        logger.info("Log inside getAllExercisesFromWorkoutById from Workout Controller");
        return ResponseEntity.ok(service.findAllExercisesByWorkout_Id(id));
    }

    @ResponseBody
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WorkoutReadModel> saveWorkout(@Valid @RequestBody WorkoutWriteModel toCreate) {
        logger.info("Log inside saveWorkout from Workout Controller");
        WorkoutReadModel result = service.createWorkout(toCreate);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @ResponseBody
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<WorkoutReadModel>> readAllWorkouts(){
        logger.info("Log inside readAllWorkouts from Workout Controller");
        return ResponseEntity.ok(service.readAll());
    }

    @ResponseBody
    @PatchMapping("/{id}")
    public ResponseEntity setWorkoutsExerciseToUndone(@PathVariable("id") int id) throws Exception {
        logger.info("Log inside setWorkoutsExerciseToUndone from Workout Controller");
        return ResponseEntity.ok(service.setWorkoutsExerciseToUndone(id));
    }

    @ModelAttribute("workouts")
    List<WorkoutReadModel> getWorkouts() {
        return service.readAll();
    }
}
