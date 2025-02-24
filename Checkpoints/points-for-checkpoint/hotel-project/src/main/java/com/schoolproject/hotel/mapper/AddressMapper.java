package com.schoolproject.hotel.mapper;

import com.schoolproject.hotel.controller.dto.AddressCreationRequest;
import com.schoolproject.hotel.controller.dto.AddressResponse;
import com.schoolproject.hotel.model.AddressEntity;

public class AddressMapper {

    public static AddressEntity convertDTOToDomainObj(AddressCreationRequest dto){
        return new AddressEntity(
            null,
            dto.getStreet(),
            dto.getNumber(),
            dto.getNeighborhood(),
            dto.getCity(),
            dto.getState()
        );
    }

    public static AddressResponse convertDomainObjToDTO(AddressEntity domainObj){
        return new AddressResponse(
                null,
                domainObj.getStreet(),
                domainObj.getNumber(),
                domainObj.getNeighborhood(),
                domainObj.getCity(),
                domainObj.getState()
        );
    }
}
