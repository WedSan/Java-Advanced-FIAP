package fiap.checkpoint.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Room already reserved between check in date and check out date")
public class RoomAlreadyReservedException extends RuntimeException{
    public RoomAlreadyReservedException() {
    }

    public RoomAlreadyReservedException(String message) {
        super(message);
    }

    public RoomAlreadyReservedException(String message, Throwable cause) {
        super(message, cause);
    }

    public RoomAlreadyReservedException(Throwable cause) {
        super(cause);
    }

    public RoomAlreadyReservedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
