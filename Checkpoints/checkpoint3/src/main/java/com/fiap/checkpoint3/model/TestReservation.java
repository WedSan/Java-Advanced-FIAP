package com.fiap.checkpoint3.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class TestReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate reservationDate;

    private String trainingType;

    @ManyToOne
    private Team team;

    @ManyToOne
    private RaceTrack raceTrack;

    private ReservationStatus reservationStatus;

    public TestReservation() {
    }

    public TestReservation(Long id, LocalDate reservationDate, String trainingType, ReservationStatus reservationStatus) {
        this.id = id;
        this.reservationDate = reservationDate;
        this.trainingType = trainingType;
        this.reservationStatus = reservationStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getTrainingType() {
        return trainingType;
    }

    public void setTrainingType(String trainingType) {
        this.trainingType = trainingType;
    }
}
