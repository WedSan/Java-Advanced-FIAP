package fiap.checkpoint1.exception;

public class InvalidEmailException extends IllegalArgumentException{
    public InvalidEmailException(String s) {
        super(s);
    }
}
