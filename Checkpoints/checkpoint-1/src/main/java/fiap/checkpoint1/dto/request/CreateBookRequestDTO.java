package fiap.checkpoint1.dto.request;

public record CreateBookRequestDTO(
        String name,
        String author,
        String isbn,
        String category
) {
}
