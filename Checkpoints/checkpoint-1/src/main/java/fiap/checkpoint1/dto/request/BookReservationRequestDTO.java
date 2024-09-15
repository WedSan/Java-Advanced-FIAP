package fiap.checkpoint1.dto.request;

public record BookReservationRequestDTO(
        String bookTitle,
        int userId
) {
}
