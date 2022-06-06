package bank;

import persons.Identifiable;
import persons.Person;
import validator.*;

public abstract class BankAccount implements Identifiable {
    private static long idCounter = 1;

    private Person holder;
    private double balance;
    private long id;

    public BankAccount(Person holder) {
        this.holder = holder;
        this.balance = 0.0;
        this.id = idCounter++;
    }

    public long getId() {
        return this.id;
    }

    public Person getHolder() {
        return this.holder;
    }

    public void setHolder(Person holder) {
        this.holder = holder;
    }

    public double getBalance() {
        return this.balance;
    }

    public BankAccount deposit(double amount) {
        this.balance += Validator.validateDepositAmount(amount);

        return this;
    }

    public BankAccount withdraw(double amount) {
        this.balance -= Validator.validateWithdrawAmount(amount, this.balance);

        return this;
    }

    public double checkBalance() {

        return this.balance;
    }

    @Override
    public String toString() {
        return "Id: "
                + this.getId() + "Holder: "
                + this.getHolder().getFullName()
                + " Balance: "
                + this.getBalance();
    }
}
