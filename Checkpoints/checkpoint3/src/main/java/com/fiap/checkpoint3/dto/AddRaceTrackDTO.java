package com.fiap.checkpoint3.dto;

import jakarta.validation.constraints.NotBlank;

public record AddRaceTrackDTO(
    @NotBlank
    String name,
    @NotBlank
    String location
) {
}
