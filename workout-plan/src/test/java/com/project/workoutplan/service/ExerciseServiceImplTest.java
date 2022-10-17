package com.project.workoutplan.service;

import com.project.workoutplan.data.Exercise;
import com.project.workoutplan.error.ExerciseNotFoundException;
import com.project.workoutplan.repositories.ExerciseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class ExerciseServiceImplTest {

    @Autowired
    private ExerciseService exerciseService;

    @MockBean
    private ExerciseRepository exerciseRepository;

    @BeforeEach
    void setUp() {
        Exercise exercise = new Exercise(1, "name", 5, false);

        when(exerciseRepository.findById(1))
                .thenReturn(Optional.of(exercise));

        when(exerciseService.toggleExerciseDone(1, exercise))
                .thenReturn(exercise);

    }

    @Test
    public void whenExerciseIdCorrect_thenExerciseShouldFound() throws ExerciseNotFoundException {
        int exerciseId = 1;
        Exercise found = exerciseService.getById(exerciseId);

        assertEquals(exerciseId, found.getId());
    }

    @Test
    public void whenExerciseFound_doneShouldBeChanged() throws ExerciseNotFoundException {
        boolean done = false;
        int id = 1;
        Exercise found = exerciseService.toggleExerciseDone(id,exerciseService.getById(id));


        assertEquals(done, found.isDone());
    }

}