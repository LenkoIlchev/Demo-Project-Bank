package main;

import bank.Bank;
import bank.BankAccount;
import bank.CheckingAccount;
import persons.AccountHolder;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("Bank");

        AccountHolder firstPerson = new AccountHolder("First", "Person", "Sofia", "Bulgaria");
        AccountHolder secondPerson = new AccountHolder("Second", "Person", "Burgas", "Bulgaria");

        BankAccount acc1 = new CheckingAccount(firstPerson);
        BankAccount acc2 = new CheckingAccount(firstPerson);
        BankAccount acc3 = new CheckingAccount(firstPerson);

        firstPerson.addAccount(acc1);
        acc1.deposit(100);
        acc1.deposit(55.55);

        firstPerson.addAccount(acc2);
        acc2.deposit(111.222);
        acc2.deposit(999.123);

        firstPerson.addAccount(acc3);
        acc3.deposit(222.33);
        acc3.deposit(444.55);
        acc3.withdraw(100);


        BankAccount acc4 = new CheckingAccount(secondPerson);
        BankAccount acc5 = new CheckingAccount(secondPerson);
        BankAccount acc6 = new CheckingAccount(secondPerson);
        secondPerson.addAccount(acc4);
        secondPerson.addAccount(acc5);
        secondPerson.addAccount(acc6);

        firstPerson.transferBetweenOwnAccounts(2, 1, 200.00);
        firstPerson.transferToAnotherPerson(2, secondPerson, 5, 200.00);

        bank.addHolder(firstPerson);
        bank.addHolder(secondPerson);

        System.out.println(bank);
    }
}
