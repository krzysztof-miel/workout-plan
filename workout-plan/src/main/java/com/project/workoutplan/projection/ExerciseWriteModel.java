package com.project.workoutplan.projection;

import com.project.workoutplan.data.Exercise;
import com.project.workoutplan.data.Workout;

import javax.validation.constraints.NotBlank;

public class ExerciseWriteModel {
    @NotBlank(message = "Exercise's name must not be empty")
    private String name;
    private int reps;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public Exercise toExercise(Workout workout) {
        return new Exercise(name, reps, workout);
    }
}
