package com.schoolproject.hotel.model;

@Entity
public class HotelEntity {

    @Id
    private Long id;

    private String name;

    private String address;

    private int availableRooms;

    public HotelEntity() {
    }

    public HotelEntity(Long id, String name, String address, int availableRooms) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(int availableRooms) {
        this.availableRooms = availableRooms;
    }
}
