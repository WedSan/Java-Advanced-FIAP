package com.schoolproject.hotel.service;

import com.schoolproject.hotel.controller.dto.HotelCreationRequest;
import com.schoolproject.hotel.controller.dto.HotelResponse;
import com.schoolproject.hotel.mapper.HotelMapper;
import com.schoolproject.hotel.model.AddressEntity;
import com.schoolproject.hotel.model.HotelEntity;
import com.schoolproject.hotel.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    private final HotelRepository repository;

    private AddressService addressService;

    public HotelService(HotelRepository repository, AddressService addressService) {
        this.repository = repository;
        this.addressService = addressService;
    }

    public List<HotelResponse> getHotels(){
        List<HotelEntity> hotels = repository.findAll();
        return hotels.stream().map((e)-> HotelMapper.convertDomainObjToDTO(e)).toList();
    }

    public HotelResponse getHotel(Long hotelId){
        Optional<HotelEntity> hotelOptional = repository.findById(hotelId);
        if (hotelOptional.isEmpty()){
            return null;
        }

        return HotelMapper.convertDomainObjToDTO(hotelOptional.get());
    }

    public void registerHotel(HotelCreationRequest req){
        HotelEntity hotel = HotelMapper.convertDTOToHotelObj(req);
        AddressEntity address = addressService.saveAddress(req.getAddress());
        hotel.setAddress(address);
        repository.save(hotel);
    }

}
