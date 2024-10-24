package fiap.checkpoint.DTO;

public record ClientDTO(
        Long id,
        String name,
        String email,
        String document
) {
}
