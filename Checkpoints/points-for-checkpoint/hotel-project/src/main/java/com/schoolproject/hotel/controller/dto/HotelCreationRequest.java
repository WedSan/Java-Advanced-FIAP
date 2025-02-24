package com.schoolproject.hotel.controller.dto;

public record HotelCreationRequest(
        String name,

        AddressCreationRequest address,

        int availableRooms
) {
}
