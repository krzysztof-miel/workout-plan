package com.project.workoutplan.repositories;

import com.project.workoutplan.data.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepository  extends JpaRepository<Exercise, Integer> {

    public boolean existsByDoneIsFalseAndWorkout_Id(Integer workoutId);

    public List<Exercise> findAllByWorkout_Id(Integer id);
}
