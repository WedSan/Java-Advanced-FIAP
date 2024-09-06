package net.andrelson.controller.exceptionHandler;

import net.andrelson.dto.response.error.ErrorResponse;
import net.andrelson.factory.ErrorResponseFactory;
import net.andrelson.meeting.exception.MeetingRoomAlreadyExistsException;
import net.andrelson.meeting.exception.MeetingRoomNotFoundException;
import net.andrelson.meeting.exception.MeetingRoomReservationNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class MeetingRoomExceptionHandler {

    @ExceptionHandler(MeetingRoomAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleMeetingRoomAlreadyExistsException(MeetingRoomAlreadyExistsException ex,
                                                                                 WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(),
                HttpStatus.CONFLICT.value(),
                "Conflict",
                "The meeting room already exists",
                request.getDescription(false)
                );

        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }

    @ExceptionHandler({MeetingRoomNotFoundException.class, MeetingRoomReservationNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleMeetingRoomNotFoundException(RuntimeException ex,
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
