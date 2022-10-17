package com.project.workoutplan.projection;

import com.project.workoutplan.data.Workout;

import java.util.Set;
import java.util.stream.Collectors;

public class WorkoutWriteModel {
    private Integer id;
    private String name;
    private Set<ExerciseWriteModel> exercises;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ExerciseWriteModel> getExercises() {
        return exercises;
    }

    public void setExercises(Set<ExerciseWriteModel> exercises) {
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
