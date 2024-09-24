package com.fiap.class_23_09_2024.dto.request;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record StudentCreationRequestDTO(
    @NotNull
    @NotBlank
    String name,

    @Past
    LocalDate birthday,

    @NotNull
    @NotBlank
    String course,

    @Email(message = "Invalid email. Email example: example@hotmail.com")
    String email,

    @CPF(message = "Invalid document")
    String document
) {
}
