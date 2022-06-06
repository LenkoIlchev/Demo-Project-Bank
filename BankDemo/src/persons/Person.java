package persons;

import validator.Validator;

public abstract class Person implements Identifiable {
    private static long idCounter = 1;

    private long id;
    private String firstName;
    private String lastName;
    private String city;
    private String country;

    public Person(String firstName, String lastName, String city, String country) {
        this.generateId();
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setCity(city);
        this.setCountry(country);
    }

    @Override
    public long getId() {
        return this.id;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public String getCity() {
        return this.city;
    }

    public String getCountry() {
        return this.country;
    }

    private void setFirstName(String firstName) {
        this.firstName = Validator.validateName(firstName);
    }

    private void setLastName(String lastName) {
        this.lastName = Validator.validateName(lastName);
    }

    private void generateId() {
        this.id = idCounter;
        idCounter++;
    }

    public void setCity(String city) {
        this.city = Validator.validateCityOrCountryName(city);
    }

    public void setCountry(String country) {
        this.country = Validator.validateCityOrCountryName(country);
    }

    @Override
    public String toString() {
        return "ID: " + this.getId() + " Name: " + this.getFullName() + ", " + this.getCity() + ", " + this.getCountry();
    }
}
