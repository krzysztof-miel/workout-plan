package com.project.workoutplan.data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "workouts")
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Exercise's name cannot be null or whitespace")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workout")
    private Set<Exercise> exercises;
    private boolean done;


    public Workout() {
    }

    public Workout(int id, String name, boolean done) {
        this.id = id;
        this.name = name;
        this.done = done;
    }

    public Workout(int id, String name, Set<Exercise> exercises) {
        this.id = id;
        this.name = name;
        this.exercises = exercises;
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

    public Set<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(Set<Exercise> exercises) {
        this.exercises = exercises;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
