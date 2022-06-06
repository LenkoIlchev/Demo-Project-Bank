package validator;

import exceptions.*;

public class Validator {
    private static final String nameRegex = "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$";
    private static final String cityCountryRegex = "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$";
    private static final double MIN_AMOUNT = 0;

    public static String validateName(String name) {
        if (!name.matches(nameRegex)) {
            throw new InvalidNameException();
        }

        return name;
    }

    public static String validateCityOrCountryName(String input) {
        if (!input.matches(cityCountryRegex)) {
            throw new InvalidCityOrCountryNameException();
        }

        return input;
    }

    public static double validateDepositAmount(double amount) {
        if (amount <= MIN_AMOUNT) {
            throw new NegativeAmountException();
        }

        return amount;
    }

    public static double validateWithdrawAmount(double amount, double balance) {
        if (amount < MIN_AMOUNT) {
            throw new NegativeAmountException();
        }

        if (amount > balance) {
            throw new OverdraftException();
        }

        return amount;
    }
}
