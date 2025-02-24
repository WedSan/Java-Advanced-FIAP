package com.schoolproject.hotel.mapper;

import com.schoolproject.hotel.controller.dto.HotelCreationRequest;
import com.schoolproject.hotel.controller.dto.HotelResponse;
import com.schoolproject.hotel.model.HotelEntity;

public class HotelMapper {

    public static HotelEntity convertDTOToHotelObj(HotelCreationRequest hotelDTO){
        return new HotelEntity(
                null,
                hotelDTO.getName(),
                AddressMapper.convertDTOToDomainObj(hotelDTO.getAddress()),
                hotelDTO.getAvailableRooms()
        );
    }

    public static HotelResponse convertDomainObjToDTO(HotelEntity hotel){
        return new HotelResponse(
                hotel.getId(),
                hotel.getName(),
                AddressMapper.convertDomainObjToDTO(hotel.getAddress()),
                hotel.getAvailableRooms()
        );
    }

}   
