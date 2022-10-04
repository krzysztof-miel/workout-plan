package com.project.workoutplan.repositories;

import com.project.workoutplan.data.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ExerciseRepository  extends JpaRepository<Exercise, Integer> {
}
