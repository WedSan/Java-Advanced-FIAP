package fiap.checkpoint.DTO;

import java.time.LocalDate;
import java.util.List;

public record ReservationDTO(
        Long id,
        Long userId,
        List<Long> roomId,
        LocalDate checkInDate,
        LocalDate checkOutDate
) {
}
