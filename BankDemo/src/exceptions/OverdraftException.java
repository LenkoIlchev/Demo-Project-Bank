package exceptions;

public class OverdraftException extends RuntimeException {
    public OverdraftException() {
        super(ExceptionMessages.OVERDRAFT_MESSAGE);
    }
}
