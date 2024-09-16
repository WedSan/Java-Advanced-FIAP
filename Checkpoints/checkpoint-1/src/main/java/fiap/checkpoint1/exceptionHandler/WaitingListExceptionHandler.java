package fiap.checkpoint1.exceptionHandler;

import fiap.checkpoint1.dto.error.ErrorResponseDTO;
import fiap.checkpoint1.mapper.ErrorMapper;
import fiap.checkpoint1.exception.WaitingListNotFoundException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class WaitingListExceptionHandler {

    @ExceptionHandler(WaitingListNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleWaitingListNotFoundException(WaitingListNotFoundException ex, WebRequest request){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                ErrorMapper.mapToErrorResponseDTO(HttpStatus.NOT_FOUND, "Waiting List not found", ex.getMessage(), request)
        );
    }
}
