package fiap.checkpoint1.dto.response;

import fiap.checkpoint1.model.Book;
import fiap.checkpoint1.model.User;

import java.time.LocalDateTime;

public record ReservationResponseDTO(
        long reservationId,
        UserResponseDTO user,
        BookResponseDTO book,
        LocalDateTime reservationDate
) {
}
