package com.project.wedsan.JavaCheckpoint4.service;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherAPIBodyPayload {

    private double temperature;

    private double windspeed;

    private int weathercode;

    public WeatherAPIBodyPayload(double temperature, double windspeed, int weathercode) {
        this.temperature = temperature;
        this.windspeed = windspeed;
        this.weathercode = weathercode;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(double windspeed) {
        this.windspeed = windspeed;
    }

    public int getWeathercode() {
        return weathercode;
    }

    public void setWeathercode(int weathercode) {
        this.weathercode = weathercode;
    }
}
