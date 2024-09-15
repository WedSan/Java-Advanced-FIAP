package fiap.checkpoint1.exceptionHandler;

import fiap.checkpoint1.dto.error.ErrorResponseDTO;
import fiap.checkpoint1.exception.*;
import fiap.checkpoint1.mapper.ErrorMapper;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class BookExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleBookNotFoundException(BookNotFoundException ex, WebRequest request){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                ErrorMapper.mapToErrorResponseDTO(HttpStatus.NOT_FOUND, "Book not found", ex.getMessage(), request));
    }

    @ExceptionHandler(BookAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDTO> handleBookAlreadyExistsException(BookAlreadyExistsException ex, WebRequest request){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
                ErrorMapper.mapToErrorResponseDTO(HttpStatus.CONFLICT, "Book already exists", ex.getMessage(), request));
    }

    @ExceptionHandler(BookCategoryException.class)
    public ResponseEntity<ErrorResponseDTO> handleBookCategoryException(BookCategoryException ex, WebRequest request){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                ErrorMapper.mapToErrorResponseDTO(HttpStatus.NOT_FOUND, "Book with category not found", ex.getMessage(), request));
    }

    @ExceptionHandler(InvalidBookAttributeException.class)
    public ResponseEntity<ErrorResponseDTO> handleInvalidBookAttributeException(InvalidBookAttributeException ex, WebRequest request){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                        ErrorMapper.mapToErrorResponseDTO(HttpStatus.BAD_REQUEST, "Invalid Book Attribute", ex.getMessage(), request));
    }


    @ExceptionHandler(InvalidSortOptionException.class)
    public ResponseEntity<ErrorResponseDTO> handleInvalidBookAttributeException(InvalidSortOptionException ex, WebRequest request){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                ErrorMapper.mapToErrorResponseDTO(HttpStatus.BAD_REQUEST, "Sort option invalid", ex.getMessage(), request));
    }
}
