package com.project.workoutplan.service;

import com.project.workoutplan.data.Exercise;
import com.project.workoutplan.data.Workout;
import com.project.workoutplan.error.WorkoutNotFoundException;
import com.project.workoutplan.projection.WorkoutReadModel;
import com.project.workoutplan.projection.WorkoutWriteModel;

import java.util.List;

public interface WorkoutService {

    public WorkoutReadModel createWorkout(WorkoutWriteModel toCreate);

    public List<WorkoutReadModel> readAll();

//    public void toggleWorkout(int workoutId) throws WorkoutNotFoundException;

    public List<Exercise> findAllExercisesByWorkout_Id(int id) throws WorkoutNotFoundException;

    public Workout getWorkoutById(int id) throws WorkoutNotFoundException;

    public Workout setWorkoutsExerciseToUndone(int id) throws WorkoutNotFoundException;
}
