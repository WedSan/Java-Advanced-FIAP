package fiap.checkpoint.DTO;

import java.math.BigDecimal;

public record ServiceDTO(
        Long id,
        String description,
        BigDecimal price
) {
}
