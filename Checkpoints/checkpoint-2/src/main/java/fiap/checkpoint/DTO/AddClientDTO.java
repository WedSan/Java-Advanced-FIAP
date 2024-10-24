package fiap.checkpoint.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

public record AddClientDTO(
        @NotBlank
        String name,
        @Email
        String email,
        @CPF
        String document
) {
}
