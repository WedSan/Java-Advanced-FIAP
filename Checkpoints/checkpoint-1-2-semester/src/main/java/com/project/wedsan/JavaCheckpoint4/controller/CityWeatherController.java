package com.project.wedsan.JavaCheckpoint4.controller;

import com.project.wedsan.JavaCheckpoint4.controller.dto.WeatherResponse;
import com.project.wedsan.JavaCheckpoint4.exception.CityNotFoundException;
import com.project.wedsan.JavaCheckpoint4.model.CityEntity;
import com.project.wedsan.JavaCheckpoint4.service.CityService;
import com.project.wedsan.JavaCheckpoint4.service.WeatherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedList;

@Controller
@RequestMapping("/city/weather")
public class CityWeatherController {

    private WeatherService weatherService;

    private CityService cityService;

    public CityWeatherController(WeatherService weatherService, CityService cityService) {
        this.weatherService = weatherService;
        this.cityService = cityService;
    }

    @GetMapping("/{id}")
    public String getWeatherPage(@PathVariable("id") Long cityId, Model model) {
        CityEntity city;
        try{
             city = cityService.getCity(cityId);
        } catch(CityNotFoundException ex){
            return "page_not_found";
        }
        LinkedList<WeatherResponse> cityWeatherHistory = weatherService.getCityWeatherList(city);
        WeatherResponse currentCityWeather = weatherService.getCityWeather(city);
        model.addAttribute("currentCityWeather", currentCityWeather);
        model.addAttribute("cityWeatherList", cityWeatherHistory);
        return "city_weather_details_list";
    }
}
