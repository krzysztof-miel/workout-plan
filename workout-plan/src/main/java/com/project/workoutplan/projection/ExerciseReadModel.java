package com.project.workoutplan.projection;

import com.project.workoutplan.data.Exercise;

public class ExerciseReadModel {
    private String name;
    private int reps;
    private boolean done;

    public ExerciseReadModel(Exercise source) {
        name= source.getName();
        reps = source.getReps();
        done = source.isDone();
    }

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

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
