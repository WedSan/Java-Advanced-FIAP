package net.andrelson.factory;

import net.andrelson.dto.response.error.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

public class ErrorResponseFactory {

    public static ErrorResponse createErrorResponse(HttpStatus status, String error, String message, WebRequest request){
        return new ErrorResponse(
                LocalDateTime.now(),
                status.value(),
                error,
                message,
                request.getDescription(false).replace("uri=", "")
        );
    }
}
