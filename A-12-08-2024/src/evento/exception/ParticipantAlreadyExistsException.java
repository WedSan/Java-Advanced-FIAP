package evento.exception;

public class ParticipantAlreadyExistsException extends Exception {

    public ParticipantAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParticipantAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    public ParticipantAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ParticipantAlreadyExistsException() {
    }
}
