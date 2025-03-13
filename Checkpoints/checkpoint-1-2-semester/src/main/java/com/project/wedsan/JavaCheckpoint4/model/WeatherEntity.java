package com.project.wedsan.JavaCheckpoint4.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_WEATHER")
public class WeatherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double temperature;

    private double windVelocity;

    private String weatherConditions;

    private LocalDateTime QueryDateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private CityEntity cityEntity;


    public WeatherEntity() {
    }

    public WeatherEntity(Long id, float temperature, float windVelocity, String weatherConditions, LocalDateTime queryDateTime, CityEntity cityEntity) {
        this.id = id;
        this.temperature = temperature;
        this.windVelocity = windVelocity;
        this.weatherConditions = weatherConditions;
        QueryDateTime = queryDateTime;
        this.cityEntity = cityEntity;
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

    public CityEntity getCityEntity() {
        return cityEntity;
    }

    public void setCityEntity(CityEntity cityEntity) {
        this.cityEntity = cityEntity;
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
        return QueryDateTime;
    }

    public void setQueryDateTime(LocalDateTime queryDateTime) {
        QueryDateTime = queryDateTime;
    }
}
