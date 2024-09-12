package fiap.checkpoint1.model.exception;

public class BookAlreadyExistsException extends RuntimeException{
    public BookAlreadyExistsException(String message) {
        super(message);
    }
}
