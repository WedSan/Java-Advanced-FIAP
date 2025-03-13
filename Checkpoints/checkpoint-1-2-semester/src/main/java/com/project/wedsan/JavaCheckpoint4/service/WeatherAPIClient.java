package com.project.wedsan.JavaCheckpoint4.service;

import com.project.wedsan.JavaCheckpoint4.model.CityEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class WeatherAPIClient {

    private final RestClient weatherRestClient;

    private final String defaultUrl = "https://api.open-meteo.com/v1/forecast";

    public WeatherAPIClient() {
        this.weatherRestClient = RestClient.create();
    }

    public WeatherAPIBodyPayload getCityCurrentWeather(CityEntity city){
        String uri = defaultUrl + "?latitude=" + city.getLatitude() + "&longitude=" + city.getLongitude() + "&current_weather=true";
        System.out.println(uri);
        WeatherAPIBodyResponse response = weatherRestClient.get().uri(uri).retrieve().body(WeatherAPIBodyResponse.class);
        return response.getCurrentWeather();
    }
}
