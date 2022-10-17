package com.project.workoutplan.projection;

import com.project.workoutplan.data.Workout;

import java.util.Set;
import java.util.stream.Collectors;

public class WorkoutReadModel {
    private int id;
    private String name;
    private Set<ExerciseReadModel> exercises;

    public WorkoutReadModel(Workout source) {
        id = source.getId();
        name = source.getName();
        exercises = source.getExercises().stream()
                .map(ExerciseReadModel::new)
                .collect(Collectors.toSet());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ExerciseReadModel> getExercises() {
        return exercises;
    }

    public void setExercises(Set<ExerciseReadModel> exercises) {
        this.exercises = exercises;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
