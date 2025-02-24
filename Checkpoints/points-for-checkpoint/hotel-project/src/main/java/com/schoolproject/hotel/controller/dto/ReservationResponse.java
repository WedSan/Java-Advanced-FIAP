package com.schoolproject.hotel.controller.dto;

import java.time.LocalDate;

public class ReservationResponse {

    private LocalDate startDate;

    private LocalDate endDate;

    private String username;

    public ReservationResponse(LocalDate startDate, LocalDate endDate, String username) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.username = username;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
