package fiap.checkpoint1.exception;

public class WaitingListNotFoundException extends RuntimeException{
    public WaitingListNotFoundException(String message) {
        super(message);
    }
}
