package com.project.wedsan.JavaCheckpoint4.controller.dto;

import jakarta.validation.constraints.*;
import org.springframework.format.annotation.NumberFormat;

public class CreateCityReq {

    @NotEmpty
    @Size(min=2, max=64, message="{register.error.name.length}")
    private String name;

    @NotNull
    private double latitude;

    @NotNull
    private double longitude;

    public CreateCityReq() {
    }

    public CreateCityReq(String name, float latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
