package com.project.wedsan.JavaCheckpoint4.exception;

public class CityAlreadyExistsByName extends RuntimeException{

    public CityAlreadyExistsByName() {
    }

    public CityAlreadyExistsByName(String message) {
        super(message);
    }

    public CityAlreadyExistsByName(String message, Throwable cause) {
        super(message, cause);
    }

    public CityAlreadyExistsByName(Throwable cause) {
        super(cause);
    }

    public CityAlreadyExistsByName(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
