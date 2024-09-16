package fiap.checkpoint1.dto.response;

import fiap.checkpoint1.model.Book;

public record BookQuantityResponseDTO(
        Book book,
        int quantity
) {
}
