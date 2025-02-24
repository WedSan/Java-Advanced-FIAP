package com.schoolproject.hotel.controller.dto;

public record AddressCreationRequest(

        String street,

        String number,

        String neighborhood,

        String city,

        String state
) {
}
