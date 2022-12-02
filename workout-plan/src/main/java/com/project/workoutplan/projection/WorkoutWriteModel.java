package com.project.workoutplan.projection;

import com.project.workoutplan.data.Workout;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WorkoutWriteModel {
    private Integer id;
    @NotBlank(message = "Workout's name must not be empty")
    private String name;
    @Valid
    private List<ExerciseWriteModel> exercises = new ArrayList<>();

    public WorkoutWriteModel(Integer id, String name, List<ExerciseWriteModel> exercises) {
        this.id = id;
        this.name = name;
        this.exercises = exercises;
    }

    public WorkoutWriteModel() {
        exercises.add(new ExerciseWriteModel());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ExerciseWriteModel> getExercises() {
        return exercises;
    }

    public void setExercises(List<ExerciseWriteModel> exercises) {
        this.exercises = exercises;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Workout toWorkout() {
        var result = new Workout();
        result.setName(name);
        result.setExercises(
                exercises.stream()
                        .map(source -> source.toExercise(result))
                        .collect(Collectors.toSet())
        );
        return result;
    }
}
