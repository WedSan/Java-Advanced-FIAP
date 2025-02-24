package com.schoolproject.hotel.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_HOTEL_PFP")
public class HotelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne
    private AddressEntity address;

    private int availableRooms;

    public HotelEntity() {
    }

    public HotelEntity(Long id, String name, AddressEntity address, int availableRooms) {
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

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public int getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(int availableRooms) {
        this.availableRooms = availableRooms;
    }
}
