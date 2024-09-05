package net.andrelson.controller.exceptionHandler;

import net.andrelson.dto.response.error.ErrorResponse;
import net.andrelson.factory.ErrorResponseFactory;
import net.andrelson.meeting.exception.MeetingRoomNotFoundException;
import net.andrelson.meeting.exception.MeetingRoomReservationNotFoundException;
import net.andrelson.meeting.exception.UnvailableBookingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class BookingExceptionHandler {

    @ExceptionHandler(UnvailableBookingException.class)
    public ResponseEntity<ErrorResponse> handleUnvailableBookingException(Exception ex,
                                                                            WebRequest request){
        ErrorResponse errorResponse = ErrorResponseFactory.createErrorResponse(
                HttpStatus.NOT_FOUND,
                "Not Found",
                ex.getMessage(),
                request
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}
