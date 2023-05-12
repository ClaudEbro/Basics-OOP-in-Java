package net.ebrottie.model;

import java.util.UUID;

public abstract class BankAccount {
    private String accountId;
    private double balance;
    private String currency;
    private AccountStatus status;

    //Constructor
    public BankAccount() {
        this.accountId = UUID.randomUUID().toString(); //generate a default unique account ID
        this.status = AccountStatus.CREATED;
    }

    //Overload the constructor by an initial balance of the BankAccount
    public BankAccount(String currency, double initialBalance) {
        this(); //to call the other constructor
        this.currency = currency;
        this.balance = initialBalance;
    }

    public String getAccountId() {
        return accountId;
    }


    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    @Override //redefine the method toString to display the state of the object
    public String toString() {
        return "BankAccount{" +
                "accountId='" + accountId + '\'' +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                ", status=" + status +
                '}';
    }

    public  abstract String getType();
}
