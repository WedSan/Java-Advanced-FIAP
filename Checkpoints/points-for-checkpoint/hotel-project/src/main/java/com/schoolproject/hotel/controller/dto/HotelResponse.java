package com.schoolproject.hotel.controller.dto;

public record HotelResponse(
     Long id,

     String name,

     String address,

     int availableRooms
) {
}
