package exceptions;

public class NegativeAmountException extends RuntimeException {
    public NegativeAmountException() {
        super(ExceptionMessages.NEGATIVE_AMOUNT_MESSAGE);
    }
}
