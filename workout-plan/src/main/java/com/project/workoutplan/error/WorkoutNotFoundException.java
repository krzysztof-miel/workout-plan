package com.project.workoutplan.error;

public class WorkoutNotFoundException extends Exception{
    public WorkoutNotFoundException() {
        super();
    }

    public WorkoutNotFoundException(String message) {
        super(message);
    }

    public WorkoutNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public WorkoutNotFoundException(Throwable cause) {
        super(cause);
    }

    protected WorkoutNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
