package fiap.checkpoint1.exceptionHandler;

import fiap.checkpoint1.dto.error.ErrorResponseDTO;
import fiap.checkpoint1.mapper.ErrorMapper;
import fiap.checkpoint1.exception.InvalidEmailException;
import fiap.checkpoint1.exception.UserNotFoundException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class UserExceptionHandler {

    @ExceptionHandler(InvalidEmailException.class)
    public ResponseEntity<ErrorResponseDTO> handleInvalidEmailException(InvalidEmailException ex, WebRequest request){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
                ErrorMapper.mapToErrorResponseDTO(HttpStatus.CONFLICT, "Invalid Email", ex.getMessage(), request));
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleUserNotFoundException (UserNotFoundException ex, WebRequest request){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                ErrorMapper.mapToErrorResponseDTO(HttpStatus.NOT_FOUND, "User Not Found", ex.getMessage(), request));
    }
}
