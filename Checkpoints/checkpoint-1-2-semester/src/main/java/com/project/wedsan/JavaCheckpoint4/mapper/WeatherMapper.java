package com.project.wedsan.JavaCheckpoint4.mapper;

import com.project.wedsan.JavaCheckpoint4.controller.dto.WeatherResponse;
import com.project.wedsan.JavaCheckpoint4.model.WeatherEntity;
import com.project.wedsan.JavaCheckpoint4.service.WeatherAPIBodyPayload;

import java.time.LocalDateTime;

public class WeatherMapper {

    public static WeatherEntity transformAPIPayloadToDomainObj(WeatherAPIBodyPayload payload){
        WeatherEntity weatherEntity = new WeatherEntity();
        weatherEntity.setTemperature(payload.getTemperature());
        weatherEntity.setWindVelocity(payload.getWindspeed());
        weatherEntity.setWeatherConditions(getWeatherConditionByCode(payload.getWeathercode()));
        weatherEntity.setQueryDateTime(LocalDateTime.now());
        return weatherEntity;
    }

    public static WeatherResponse transformDomainObjToDTO(WeatherEntity weatherEntity){
        return new WeatherResponse(
            weatherEntity.getId(),
            weatherEntity.getTemperature(),
            weatherEntity.getWindVelocity(),
            weatherEntity.getWeatherConditions(),
            weatherEntity.getQueryDateTime()
        );
    }

    private static String getWeatherConditionByCode(int weatherCode){
        return switch (weatherCode) {
            case 0 -> "Clear sky";
            case 1 -> "Mainly clear";
            case 2 -> "Partly cloudy";
            case 3 -> "Overcast";
            case 45 -> "Fog";
            case 48 -> "Depositing rime fog";
            case 51 -> "Light drizzle";
            case 53 -> "Moderate drizzle";
            case 55 -> "Dense drizzle";
            case 56 -> "Light freezing drizzle";
            case 57 -> "Dense freezing drizzle";
            case 61 -> "Light rain";
            case 63 -> "Moderate rain";
            case 65 -> "Heavy rain";
            case 66 -> "Light freezing rain";
            case 67 -> "Heavy freezing rain";
            case 71 -> "Light snow";
            case 73 -> "Moderate snow";
            case 75 -> "Heavy snow";
            case 77 -> "Snow grains";
            case 80 -> "Light showers of rain";
            case 81 -> "Moderate showers of rain";
            case 82 -> "Heavy showers of rain";
            case 85 -> "Light showers of snow";
            case 86 -> "Heavy showers of snow";
            case 95 -> "Thunderstorm with light rain";
            case 96 -> "Thunderstorm with heavy rain";
            case 99 -> "Thunderstorm with hail";
            default -> "Unknown weather code";
        };
    }
}
