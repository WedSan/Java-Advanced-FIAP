package com.schoolproject.hotel.service;

import com.schoolproject.hotel.controller.dto.HotelCreationRequest;
import com.schoolproject.hotel.controller.dto.HotelResponse;
import com.schoolproject.hotel.model.HotelEntity;
import com.schoolproject.hotel.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    private HotelRepository repository;

    public HotelService(HotelRepository repository) {
        this.repository = repository;
    }

    public List<HotelResponse> getHotels(){
        List<HotelEntity> hotels = repository.findAll();
        return hotels.stream().map((e)-> convertToHotelDTO(e)).toList();
    }

    public String registerHotel(HotelCreationRequest req){
        HotelEntity hotel = convertToHotelObj(req);

    }

    public HotelEntity convertToHotelObj(HotelCreationRequest hotelDTO){
        return new HotelEntity(
            null,
            hotelDTO.name(),
            hotelDTO.address(),
            hotelDTO.availableRooms()
        );
    }

    public HotelResponse convertToHotelDTO(HotelEntity hotel){
        return new HotelResponse(
                hotel.getId(),
                hotel.getName(),
                hotel.getAddress(),
                hotel.getAvailableRooms()
        );
    }


}
