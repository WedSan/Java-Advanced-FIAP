package com.schoolproject.hotel.controller.dto;

public class HotelCreationRequest{
    String name;

    AddressCreationRequest address;

    int availableRooms;

    public HotelCreationRequest(String name, AddressCreationRequest address, int availableRooms) {
        this.name = name;
        this.address = address;
        this.availableRooms = availableRooms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressCreationRequest getAddress() {
        return address;
    }

    public void setAddress(AddressCreationRequest address) {
        this.address = address;
    }

    public int getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(int availableRooms) {
        this.availableRooms = availableRooms;
    }
}
