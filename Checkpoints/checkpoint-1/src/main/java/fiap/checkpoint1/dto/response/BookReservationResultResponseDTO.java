package fiap.checkpoint1.dto.response;

import fiap.checkpoint1.model.BookReservation;

public record BookReservationResultResponseDTO(
        BookReservation bookReservation,
        String reservationMessage,
        boolean isWaitingList
) {
}
