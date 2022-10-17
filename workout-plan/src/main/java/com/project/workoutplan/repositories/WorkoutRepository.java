package com.project.workoutplan.repositories;

import com.project.workoutplan.data.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Integer> {

    @Override
    @Query("select distinct w from Workout w join fetch w.exercises")
    List<Workout> findAll();
}
