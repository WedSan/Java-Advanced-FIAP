package com.project.wedsan.JavaCheckpoint4.mapper;

import com.project.wedsan.JavaCheckpoint4.controller.dto.CreateCityReq;
import com.project.wedsan.JavaCheckpoint4.model.CityEntity;

public class CityMapper {

    public static CityEntity transformDTOToDomainObj(CreateCityReq request){
        return new CityEntity(
                null,
                request.getName(),
                request.getLatitude(),
                request.getLongitude()
        );
    }
}
