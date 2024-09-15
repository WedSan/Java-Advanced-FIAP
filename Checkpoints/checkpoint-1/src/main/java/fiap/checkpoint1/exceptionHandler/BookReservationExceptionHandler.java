package fiap.checkpoint1.exceptionHandler;

import fiap.checkpoint1.dto.error.ErrorResponseDTO;
import fiap.checkpoint1.mapper.ErrorMapper;
import fiap.checkpoint1.exception.CancellationReservationException;
import fiap.checkpoint1.exception.ReservationException;
import fiap.checkpoint1.exception.ReservationNotFoundException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class BookReservationExceptionHandler {


    @ExceptionHandler(ReservationException.class)
    public ResponseEntity<ErrorResponseDTO> handleReservationException(ReservationException ex, WebRequest request){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
                ErrorMapper.mapToErrorResponseDTO(HttpStatus.CONFLICT, "Reservation Error", ex.getMessage(), request));
    }

    @ExceptionHandler(ReservationNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleReservationNotFoundException(ReservationNotFoundException ex, WebRequest request){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
                ErrorMapper.mapToErrorResponseDTO(HttpStatus.NOT_FOUND, "Reservation Not Found", ex.getMessage(), request));
    }

    @ExceptionHandler(CancellationReservationException.class)
    public ResponseEntity<ErrorResponseDTO> handleCancellationReservationException(CancellationReservationException ex, WebRequest request){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
                ErrorMapper.mapToErrorResponseDTO(HttpStatus.CONFLICT, "Cancellation Reservation Error", ex.getMessage(), request));
    }

}


