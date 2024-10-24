package fiap.checkpoint.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Room reservation date is invalid")
public class RoomReservationDateException extends RuntimeException{
    public RoomReservationDateException() {
    }

    public RoomReservationDateException(Throwable cause) {
        super(cause);
    }

    public RoomReservationDateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
