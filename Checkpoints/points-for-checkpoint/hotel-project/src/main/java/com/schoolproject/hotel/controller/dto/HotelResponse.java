package com.schoolproject.hotel.controller.dto;

public class HotelResponse{
    private Long id;

    private String name;

    private AddressResponse address;

    private int availableRooms;

    public HotelResponse() {
    }

    public HotelResponse(Long id, String name, AddressResponse address, int availableRooms) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.availableRooms = availableRooms;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressResponse getAddress() {
        return address;
    }

    public void setAddress(AddressResponse address) {
        this.address = address;
    }

    public int getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(int availableRooms) {
        this.availableRooms = availableRooms;
    }
}
