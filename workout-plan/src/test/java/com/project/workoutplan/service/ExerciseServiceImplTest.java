package com.project.workoutplan.service;

import com.project.workoutplan.data.Exercise;
import com.project.workoutplan.error.ExerciseNotFoundException;
import com.project.workoutplan.repositories.ExerciseRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ExerciseServiceImplTest {

    @Mock
    private ExerciseRepository exerciseRepository;

    @InjectMocks
    private ExerciseServiceImpl exerciseService;


    @Test
    @DisplayName("should return Exercise with given Id")
    void getById_correctExerciseId_returnExercise() throws ExerciseNotFoundException {
        //given
        Exercise exercise = new Exercise("exercise name", 5);
        when(exerciseRepository.findById(1)).thenReturn(Optional.ofNullable(exercise));

        //when
        Exercise result = exerciseService.getById(1);

        //then
        Assertions.assertEquals(result, exercise);
    }

    @Test
    @DisplayName("should throw ExerciseNotFoundException")
    void getById_incorrectExerciseId_throwExerciseNotFoundException(){

        assertThrows(ExerciseNotFoundException.class, () -> exerciseService.getById(1));

    }

    @Test
    @DisplayName("should return updated Exercise")
    void updateExerciseName_correctExerciseId_updatedSuccessful() throws ExerciseNotFoundException {

        //given
        Exercise exercise = new Exercise("exercise name", 5);
        when(exerciseRepository.findById(1)).thenReturn(Optional.ofNullable(exercise));
        when(exerciseRepository.save(Mockito.any(Exercise.class))).thenReturn(exercise);

        //when
        Exercise result = exerciseService.updateExerciseName(1, exercise);

        //then
        Assertions.assertEquals(exercise, result);

    }

    @Test
    @DisplayName("should return unchanged Exercise")
    void toggleExerciseDone_correctExerciseId_returnExerciseWithChangedDoneValue() throws ExerciseNotFoundException {

        //given
        Exercise exercise = new Exercise("exercise name", 5);
        exercise.setDone(true);
        Boolean before = exercise.isDone();


        when(exerciseRepository.findById(1)).thenReturn(Optional.ofNullable(exercise));
        when(exerciseRepository.save(Mockito.any(Exercise.class))).thenReturn(exercise);

        //when
        Exercise result = exerciseService.toggleExerciseDone(1, exercise);

        //then
        Assertions.assertEquals(!before, result.isDone());

    }

}