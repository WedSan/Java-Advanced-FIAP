package fiap.checkpoint.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Hotel still has rooms")
public class HotelStillHasRoomsException extends RuntimeException {
    public HotelStillHasRoomsException() {
    }
}
