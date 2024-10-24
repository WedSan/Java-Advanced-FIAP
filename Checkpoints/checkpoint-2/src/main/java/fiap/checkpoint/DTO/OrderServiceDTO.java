package fiap.checkpoint.DTO;

import java.time.LocalDate;
import java.util.List;

public record OrderServiceDTO(
        Long id,
        LocalDate date,
        Long reservationRoomId,
        List<Long> servicesId
) {
}
