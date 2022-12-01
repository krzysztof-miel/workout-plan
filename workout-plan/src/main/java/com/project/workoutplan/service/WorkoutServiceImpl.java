package com.project.workoutplan.service;

import com.project.workoutplan.data.Exercise;
import com.project.workoutplan.data.Workout;
import com.project.workoutplan.error.WorkoutNotFoundException;
import com.project.workoutplan.projection.WorkoutReadModel;
import com.project.workoutplan.projection.WorkoutWriteModel;
import com.project.workoutplan.repositories.ExerciseRepository;
import com.project.workoutplan.repositories.WorkoutRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkoutServiceImpl implements WorkoutService{

    private final WorkoutRepository workoutRepository;
    private final ExerciseRepository exerciseRepository;

    public WorkoutServiceImpl(WorkoutRepository workoutRepository, ExerciseRepository exerciseRepository) {
        this.workoutRepository = workoutRepository;
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public WorkoutReadModel createWorkout(WorkoutWriteModel toCreate) {
        Workout result = workoutRepository.save(toCreate.toWorkout());
        result.getExercises()
                .forEach(exerciseRepository::save);
        return new WorkoutReadModel(result);
    }

    @Override
    public List<WorkoutReadModel> readAll() {
        return workoutRepository.findAll().stream()
                .map(WorkoutReadModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<Exercise> findAllExercisesByWorkout_Id(int id) throws WorkoutNotFoundException {
        getWorkoutById(id);
        return exerciseRepository.findAllByWorkout_Id(id);
    }

    @Override
    public Workout getWorkoutById(int id) throws WorkoutNotFoundException {
        return workoutRepository.findById(id)
                .orElseThrow(() -> new WorkoutNotFoundException("Workout with given Id not found"));
    }

    @Override
    public Workout setWorkoutsExerciseToUndone(int id) throws WorkoutNotFoundException {
        Workout current = getWorkoutById(id);
        current.getExercises()
                .forEach(Exercise::setExerciseToUndone);
        return workoutRepository.save(current);

    }
}
