package com.project.workoutplan.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "exercises")
public class Exercise {
    @Id
    private int id;
    private String name;
    private int reps;
    private boolean done;

    public Exercise() {
    }

    public Exercise(int id, String name, int reps, boolean done) {
        this.id = id;
        this.name = name;
        this.reps = reps;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
