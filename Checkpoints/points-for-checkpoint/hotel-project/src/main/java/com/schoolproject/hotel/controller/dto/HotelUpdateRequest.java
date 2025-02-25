package com.schoolproject.hotel.controller.dto;

public class HotelUpdateRequest {

    private int availableRooms;

    public HotelUpdateRequest() {
    }

    public HotelUpdateRequest(int availableRooms) {
        this.availableRooms = availableRooms;
    }

    public int getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(int availableRooms) {
        this.availableRooms = availableRooms;
    }
}
