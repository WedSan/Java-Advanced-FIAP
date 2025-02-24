package com.schoolproject.hotel.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "TB_HOTEL_PFP")
public class HotelReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate startDate;

    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "hotel_id", referencedColumnName = "id")
    private HotelEntity hotels;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserClientEntity userClient;

    public HotelReservationEntity() {
    }

    public HotelReservationEntity(Long id, LocalDate startDate, LocalDate endDate, HotelEntity hotels, UserClientEntity userClient) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.hotels = hotels;
        this.userClient = userClient;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate date) {
        this.startDate = date;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public HotelEntity getHotels() {
        return hotels;
    }

    public void setHotels(HotelEntity hotels) {
        this.hotels = hotels;
    }

    public UserClientEntity getUserClient() {
        return userClient;
    }

    public void setUserClient(UserClientEntity userClient) {
        this.userClient = userClient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
