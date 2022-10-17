package com.project.workoutplan.service;

import com.project.workoutplan.data.Exercise;
import com.project.workoutplan.error.ExerciseNotFoundException;

import java.util.List;

public interface ExerciseService {
    public Exercise saveExercise(Exercise exercise);

    public List<Exercise> readAllExercises();

    public Exercise getById(int id) throws ExerciseNotFoundException;

    boolean existsByDoneIsFalseAndWorkout_Id(Integer workoutId);

    public void deleteById(int id) throws ExerciseNotFoundException;

    public boolean existsById(int id);

    public Exercise updateExerciseName(int id, Exercise exercise) throws ExerciseNotFoundException;

    public Exercise toggleExerciseDone(int id, Exercise exercise);
}
