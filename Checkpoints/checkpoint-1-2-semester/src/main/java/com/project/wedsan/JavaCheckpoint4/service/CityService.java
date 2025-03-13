package com.project.wedsan.JavaCheckpoint4.service;

import com.project.wedsan.JavaCheckpoint4.controller.dto.CityResponse;
import com.project.wedsan.JavaCheckpoint4.controller.dto.CreateCityReq;
import com.project.wedsan.JavaCheckpoint4.exception.CityNotFoundException;
import com.project.wedsan.JavaCheckpoint4.mapper.CityMapper;
import com.project.wedsan.JavaCheckpoint4.model.CityEntity;
import com.project.wedsan.JavaCheckpoint4.repository.CityRepository;
import com.project.wedsan.JavaCheckpoint4.service.validator.CityValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    private CityRepository cityRepository;

    private List<CityValidator> validators;


    public CityService(CityRepository cityRepository, List<CityValidator> validators) {
        this.cityRepository = cityRepository;
        this.validators = validators;
    }


    public void registerCity(CreateCityReq createCityReq) {
        validators.forEach(v -> v.validate(createCityReq));
        CityEntity cityEntityToBeSaved = CityMapper.transformDTOToDomainObj(createCityReq);
        cityRepository.save(cityEntityToBeSaved);
    }

    public CityEntity getCity(Long cityId){
        Optional<CityEntity> cityEntityFounded =  cityRepository.findById(cityId);
        if(cityEntityFounded.isEmpty()){
            throw new CityNotFoundException();
        }

        return cityEntityFounded.get();
    }

    public List<CityResponse> getCities(){
        return cityRepository.findAll().stream().map(e ->
            new CityResponse(
                    e.getId(),
                    e.getName(),
                    e.getLatitude(),
                    e.getLongitude())
        ).toList();
    }
}
