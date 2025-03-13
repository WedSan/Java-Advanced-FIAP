package com.project.wedsan.JavaCheckpoint4.service;

import com.project.wedsan.JavaCheckpoint4.controller.dto.WeatherResponse;
import com.project.wedsan.JavaCheckpoint4.mapper.WeatherMapper;
import com.project.wedsan.JavaCheckpoint4.model.CityEntity;
import com.project.wedsan.JavaCheckpoint4.model.WeatherEntity;
import com.project.wedsan.JavaCheckpoint4.repository.WeatherRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherService {

    private WeatherRepository weatherRepository;

    private WeatherAPIClient apiClient;


    public WeatherService(WeatherRepository weatherRepository, WeatherAPIClient apiClient) {
        this.weatherRepository = weatherRepository;
        this.apiClient = apiClient;
    }

    public WeatherResponse getCityWeather(CityEntity cityEntity){
        WeatherAPIBodyPayload currentWeatherAPI = apiClient.getCityCurrentWeather(cityEntity);
        WeatherEntity currentWeatherEntity = WeatherMapper.transformAPIPayloadToDomainObj(currentWeatherAPI);
        currentWeatherEntity.setCityEntity(cityEntity);
        currentWeatherEntity =  weatherRepository.save(currentWeatherEntity);
        return WeatherMapper.transformDomainObjToDTO(currentWeatherEntity);
    }

    public LinkedList<WeatherResponse> getCityWeatherList(CityEntity cityEntity){
        List<WeatherEntity> weatherEntities = weatherRepository.findAllByCityEntity(cityEntity);
        return weatherEntities.stream()
                .sorted(Comparator.comparing(WeatherEntity::getQueryDateTime).reversed())
                .map(e -> new WeatherResponse(e.getId(),
                e.getTemperature(),
                e.getWindVelocity(),
                e.getWeatherConditions(),
                e.getQueryDateTime())).collect(Collectors.toCollection(LinkedList::new));
    }
}
