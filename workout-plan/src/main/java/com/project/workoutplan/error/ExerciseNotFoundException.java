package com.project.workoutplan.error;

public class ExerciseNotFoundException extends Exception{
    public ExerciseNotFoundException() {
        super();
    }

    public ExerciseNotFoundException(String message) {
        super(message);
    }

    public ExerciseNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExerciseNotFoundException(Throwable cause) {
        super(cause);
    }

    protected ExerciseNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
