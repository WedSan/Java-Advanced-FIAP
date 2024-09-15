package fiap.checkpoint1.exceptionHandler;

import fiap.checkpoint1.dto.error.ErrorResponseDTO;
import fiap.checkpoint1.mapper.ErrorMapper;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponseDTO> handleRuntimeException(RuntimeException ex, WebRequest request){
        return ResponseEntity.status(500).body(
                ErrorMapper.mapToErrorResponseDTO(500, "Internal Server Error", ex.getMessage(), request));
    }
}
