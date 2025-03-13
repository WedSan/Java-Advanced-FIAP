package com.project.wedsan.JavaCheckpoint4.service;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherAPIBodyResponse {

    @JsonProperty("current_weather")
    private WeatherAPIBodyPayload currentWeather;

    public WeatherAPIBodyResponse() {
    }

    public WeatherAPIBodyResponse(WeatherAPIBodyPayload currentWeather) {
        this.currentWeather = currentWeather;
    }

    public WeatherAPIBodyPayload getCurrentWeather() {
        return currentWeather;
    }

    public void setCurrentWeather(WeatherAPIBodyPayload currentWeather) {
        this.currentWeather = currentWeather;
    }

}
