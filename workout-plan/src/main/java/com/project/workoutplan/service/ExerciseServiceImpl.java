package com.project.workoutplan.service;

import com.project.workoutplan.data.Exercise;
import com.project.workoutplan.error.ExerciseNotFoundException;
import com.project.workoutplan.repositories.ExerciseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ExerciseServiceImpl implements ExerciseService{

    private ExerciseRepository exerciseRepository;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public Exercise saveExercise(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    @Override
    public List<Exercise> readAllExercises() {
        return exerciseRepository.findAll();
    }

    @Override
    public Exercise getById(int id) throws ExerciseNotFoundException {
        Optional<Exercise> exercise = createExerciseById(id);

        if (!exercise.isPresent()) {
            throw new ExerciseNotFoundException("Exercise not found");
        }

        return exercise.get();
    }

    @Override
    public void deleteById(int id) throws ExerciseNotFoundException {
        exerciseRepository.deleteById(id);
    }

    private Optional<Exercise> createExerciseById(int id) {
        Optional<Exercise> exercise =  exerciseRepository.findById(id);
        return exercise;
    }

    @Override
    public boolean existsByDoneIsFalseAndWorkout_Id(Integer workoutId) {
        return exerciseRepository.existsByDoneIsFalseAndWorkout_Id(workoutId);
    }

    @Override
    public boolean existsById(int id) {
        return exerciseRepository.existsById(id);
    }

    @Override
    public Exercise updateExerciseName(int id, Exercise exercise) throws ExerciseNotFoundException {
        Exercise currentExercise = getById(id);

        if (Objects.nonNull(exercise.getName()) &&
                !"".equalsIgnoreCase(exercise.getName())) {
            currentExercise.setName(exercise.getName());
        }

        System.out.println("Updated successful");

        return exerciseRepository.save(currentExercise);
    }

    @Override
    public Exercise toggleExerciseDone(int id, Exercise exercise) {
        Exercise currentExercise = exerciseRepository.findById(id).get();
        currentExercise.setDone(!currentExercise.isDone());
        System.out.println("Done value changed!");
        return exerciseRepository.save(currentExercise);
    }

}
