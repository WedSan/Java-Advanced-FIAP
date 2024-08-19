package evento.exception;

public class ParticipantNotFoundException extends Exception{

    public ParticipantNotFoundException() {
    }

    public ParticipantNotFoundException(String message) {
        super(message);
    }

    public ParticipantNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParticipantNotFoundException(Throwable cause) {
        super(cause);
    }

    public ParticipantNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
