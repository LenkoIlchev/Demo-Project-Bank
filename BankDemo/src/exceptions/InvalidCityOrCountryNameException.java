package exceptions;

public class InvalidCityOrCountryNameException extends RuntimeException {

    public InvalidCityOrCountryNameException() {
        super(ExceptionMessages.INVALID_CITY_OR_COUNTRY_MESSAGE);
    }
}
