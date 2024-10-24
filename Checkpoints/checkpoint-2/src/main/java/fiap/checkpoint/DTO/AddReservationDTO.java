package fiap.checkpoint.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record AddReservationDTO(
        @NotNull
        Long userId,
        @NotNull
        List<Long> roomIds,
        @NotNull
        LocalDate checkInDate,
        @NotNull
        LocalDate checkOutDate
) {
}
