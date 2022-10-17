package com.project.workoutplan.projection;

import com.project.workoutplan.data.Exercise;
import com.project.workoutplan.data.Workout;

public class ExerciseWriteModel {
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
