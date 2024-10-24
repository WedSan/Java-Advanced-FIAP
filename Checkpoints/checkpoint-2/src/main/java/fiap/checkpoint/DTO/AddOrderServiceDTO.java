package fiap.checkpoint.DTO;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record AddOrderServiceDTO(
        @Future
        @NotNull
        LocalDate date,

        @NotNull
        Long reservationRoomId,

        @NotNull
        List<Long> serviceId
) {
}
