package net.andrelson.controller.exceptionHandler;

import net.andrelson.dto.response.error.ErrorResponse;
import net.andrelson.meeting.exception.MeetingRoomAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
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
}
