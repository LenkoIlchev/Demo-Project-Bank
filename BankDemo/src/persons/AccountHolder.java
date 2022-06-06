package persons;

import bank.BankAccount;
import exceptions.BankAccountNotExistsException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AccountHolder extends Person {
    private List<BankAccount> accounts;

    public AccountHolder(String firstName, String lastName, String city, String country) {
        super(firstName, lastName, city, country);
        this.accounts = new ArrayList<>();
    }

    public void addAccount(BankAccount account) {
        account.setHolder(this);
        this.accounts.add(account);
    }

    public double getTotalAmount() {
        double totalAmount = 0;

        for (BankAccount account : accounts) {
            totalAmount += account.getBalance();
        }

        return totalAmount;
    }

    public AccountHolder transferBetweenOwnAccounts (long fromID, long toID, double amount) {
        BankAccount fromAccount = null;
        BankAccount toAccount = null;

        for (BankAccount account : accounts) {
            if (account.getId() == fromID) {
                fromAccount = account;
            } else if (account.getId() == toID) {
                toAccount = account;
            }
        }

        if (fromAccount == null || toAccount == null) {
            throw new BankAccountNotExistsException();
        } else {
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
        }

        return this;
    }

    public AccountHolder transferToAnotherPerson(long fromAccountID, AccountHolder toPerson, long toPersonAccountID, double amount) {
        BankAccount fromAccount = null;
        BankAccount toAccount = null;

        for (BankAccount account : accounts) {
            if (account.getId() == fromAccountID) {
                fromAccount = account;
                break;
            }
        }

        for (BankAccount account : toPerson.getAccounts()) {
            if (account.getId() == toPersonAccountID) {
                toAccount = account;
                break;
            }
        }

        if (fromAccount == null || toAccount == null) {
            throw new BankAccountNotExistsException();
        } else {
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
        }

        return this;
    }

    public List<BankAccount> getAccounts() {
        return Collections.unmodifiableList(this.accounts);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
