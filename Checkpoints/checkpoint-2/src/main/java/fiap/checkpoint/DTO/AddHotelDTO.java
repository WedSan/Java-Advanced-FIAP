package fiap.checkpoint.DTO;

import jakarta.validation.constraints.NotBlank;

public record AddHotelDTO(
        @NotBlank
        String name,
        @NotBlank
        String address
) {
}
