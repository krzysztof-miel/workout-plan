package com.project.workoutplan.data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "exercises")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank()
    private String name;
    private int reps;
    private boolean done;
    @ManyToOne
    @JoinColumn(name = "workout_id")
    private Workout workout;



    public Exercise() {
    }

    public Exercise(int id, String name, int reps, boolean done) {
        this.id = id;
        this.name = name;
        this.reps = reps;
        this.done = done;
    }

    public Exercise(String name, int reps, Workout workout) {
        this.name = name;
        this.reps = reps;
        if (workout != null) {
            this.workout = workout;
        }
    }
    public Exercise(String name, int reps) {
        this.name = name;
        this.reps = reps;
        this.workout = null;
    }

    public int getId() {
        return id;
    }

    void setId(int id) {
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
    Workout getWorkout() {return workout;}

    void setWorkout(Workout workout) {this.workout = workout;}

    public void setExerciseToUndone() {
        if (isDone()){
            setDone(false);
        }
    }


}
