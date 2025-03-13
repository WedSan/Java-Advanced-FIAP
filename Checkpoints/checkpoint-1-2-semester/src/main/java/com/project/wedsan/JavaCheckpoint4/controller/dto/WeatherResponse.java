package com.project.wedsan.JavaCheckpoint4.controller.dto;

import java.time.LocalDateTime;

public class WeatherResponse {

    private Long id;

    private double temperature;

    private double windVelocity;

    private String weatherConditions;

    private LocalDateTime queryDateTime;

    public WeatherResponse() {
    }

    public WeatherResponse(Long id, double temperature, double windVelocity, String weatherConditions, LocalDateTime queryDateTime) {
        this.id = id;
        this.temperature = temperature;
        this.windVelocity = windVelocity;
        this.weatherConditions = weatherConditions;
        this.queryDateTime = queryDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getWindVelocity() {
        return windVelocity;
    }

    public void setWindVelocity(double windVelocity) {
        this.windVelocity = windVelocity;
    }

    public String getWeatherConditions() {
        return weatherConditions;
    }

    public void setWeatherConditions(String weatherConditions) {
        this.weatherConditions = weatherConditions;
    }

    public LocalDateTime getQueryDateTime() {
        return queryDateTime;
    }

    public void setQueryDateTime(LocalDateTime queryDateTime) {
        this.queryDateTime = queryDateTime;
    }
}
