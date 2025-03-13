package com.project.wedsan.JavaCheckpoint4.exception;

public class CityAlreadyExistsByLatitudeAndLongitude extends RuntimeException{

    public CityAlreadyExistsByLatitudeAndLongitude() {
    }

    public CityAlreadyExistsByLatitudeAndLongitude(String message) {
        super(message);
    }

    public CityAlreadyExistsByLatitudeAndLongitude(String message, Throwable cause) {
        super(message, cause);
    }

    public CityAlreadyExistsByLatitudeAndLongitude(Throwable cause) {
        super(cause);
    }

    public CityAlreadyExistsByLatitudeAndLongitude(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
