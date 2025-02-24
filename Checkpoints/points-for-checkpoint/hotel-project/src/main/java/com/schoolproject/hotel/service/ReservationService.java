package com.schoolproject.hotel.service;

import com.schoolproject.hotel.controller.dto.HotelResponse;
import com.schoolproject.hotel.exception.EntityNotFoundException;
import com.schoolproject.hotel.model.HotelEntity;
import com.schoolproject.hotel.model.HotelReservationEntity;
import com.schoolproject.hotel.model.UserClientEntity;
import com.schoolproject.hotel.repository.HotelRepository;
import com.schoolproject.hotel.repository.ReservationRepository;
import com.schoolproject.hotel.repository.UserClientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ReservationService {

    private ReservationRepository repository;

    private HotelRepository hotelRepository;

    private UserClientRepository userClientRepository;

    public ReservationService(ReservationRepository repository, HotelRepository hotelRepository, UserClientRepository userClientRepository) {
        this.repository = repository;
        this.hotelRepository = hotelRepository;
        this.userClientRepository = userClientRepository;
    }

    public void reserveHotel(Long hotelId, LocalDate startTime, LocalDate endTime, String username){
        Optional<HotelEntity> hotelEntityOptional = hotelRepository.findById(hotelId);
        if (hotelEntityOptional.isEmpty()){
            throw new EntityNotFoundException();
        }

        HotelEntity hotelFounded = hotelEntityOptional.get();
        UserClientEntity user = new UserClientEntity(null, username);
        user = userClientRepository.save(user);
        HotelReservationEntity reservation = new HotelReservationEntity(null, startTime, endTime, hotelFounded, user);
        repository.save(reservation);
    }

    public List<ReservationRespone> getRoomReservation(Long hotelId){

    }
}
