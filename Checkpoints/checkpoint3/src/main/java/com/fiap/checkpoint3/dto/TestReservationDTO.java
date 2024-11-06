package com.fiap.checkpoint3.dto;

import com.fiap.checkpoint3.model.RaceTrack;
import com.fiap.checkpoint3.model.ReservationStatus;
import com.fiap.checkpoint3.model.Team;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

public record TestReservationDTO(
    Long id,

    LocalDate reservationDate,

    String trainingType,

    TeamDTO team,

    RaceTrackDTO raceTrack,

    ReservationStatus reservationStatus
) {
}
