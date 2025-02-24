package com.schoolproject.hotel.repository;

import com.schoolproject.hotel.model.HotelReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<HotelReservationEntity, Long> {
}
