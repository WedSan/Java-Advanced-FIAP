package com.schoolproject.hotel.service;

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

    public HotelResponse convertToHotelDTO(HotelEntity hotel){
        return new HotelResponse(
                hotel.getId(),
                hotel.getName(),
                hotel.getAddress(),
                hotel.getAvailableRooms()
        );
    }
}
