package com.project.wedsan.JavaCheckpoint4.service.validator;

import com.project.wedsan.JavaCheckpoint4.controller.dto.CreateCityReq;
import com.project.wedsan.JavaCheckpoint4.exception.CityAlreadyExistsByLatitudeAndLongitude;
import com.project.wedsan.JavaCheckpoint4.exception.CityAlreadyExistsByName;
import com.project.wedsan.JavaCheckpoint4.repository.CityRepository;
import org.springframework.stereotype.Component;

@Component
public class CityAlreadyExistsValidator implements CityValidator {

    private CityRepository cityRepository;

    public CityAlreadyExistsValidator(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public void validate(CreateCityReq req) {
        if(cityRepository.existsByName(req.getName())){
            throw new CityAlreadyExistsByName();
        }
        else if(cityRepository.existsByLatitudeAndLongitude(
                req.getLatitude(),
                req.getLongitude())){
            throw new CityAlreadyExistsByLatitudeAndLongitude();
        }
    }
}
