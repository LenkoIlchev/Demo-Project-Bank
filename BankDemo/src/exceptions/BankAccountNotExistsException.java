package exceptions;

public class BankAccountNotExistsException extends RuntimeException {
    public BankAccountNotExistsException() {
        super(ExceptionMessages.ACCOUNT_DOES_NOT_EXISTS_MESSAGE);
    }
}
