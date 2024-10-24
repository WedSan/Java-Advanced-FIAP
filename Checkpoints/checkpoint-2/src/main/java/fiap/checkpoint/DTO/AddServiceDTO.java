package fiap.checkpoint.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record AddServiceDTO(
        @NotNull
        @NotBlank
        String description,
        BigDecimal price
) {
}
