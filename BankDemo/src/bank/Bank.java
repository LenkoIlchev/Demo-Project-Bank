package bank;

import persons.AccountHolder;
import persons.Person;
import validator.Validator;

import java.util.*;

public class Bank {
    private String name;
    private Map<AccountHolder, List<BankAccount>> holdersAndAccounts;

    public Bank(String name) {
        this.setName(name);
        this.holdersAndAccounts = new HashMap<>();
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = Validator.validateName(name);
    }

    public Map<AccountHolder, List<BankAccount>> getHoldersAndAccounts() {
        return Collections.unmodifiableMap(this.holdersAndAccounts);
    }

    public void addHolder(AccountHolder accountHolder) {
        this.holdersAndAccounts.put(accountHolder, accountHolder.getAccounts());
    }

    @Override
    public String toString() {
        String output = "";

        output += "Bank: " + this.getName() + "\nAccount holders:\n";

        for (Map.Entry<AccountHolder, List<BankAccount>> entry : this.holdersAndAccounts.entrySet()) {
            output += "Name: " + entry.getKey().getFullName() + "\nAccounts:\n";
            for(BankAccount account : entry.getKey().getAccounts()) {
                output += String.format("ID: %d Balance: %.2f\n", account.getId(), account.getBalance());
            }
        }

        return output;
    }
}
