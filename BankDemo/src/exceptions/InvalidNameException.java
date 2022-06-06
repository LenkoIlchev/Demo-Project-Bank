package exceptions;

public class InvalidNameException extends RuntimeException {

    public InvalidNameException() {
        super(ExceptionMessages.INVALID_NAME_MESSAGE);
    }
}
