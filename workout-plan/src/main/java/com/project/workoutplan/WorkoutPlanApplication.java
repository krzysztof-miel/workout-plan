package com.project.workoutplan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Validator;

@SpringBootApplication
public class WorkoutPlanApplication implements RepositoryRestConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(WorkoutPlanApplication.class, args);

		System.out.println("Hello Workout Planner Application");
	}

	@Bean
	public Validator validator() {
		return new LocalValidatorFactoryBean();
	}

}
