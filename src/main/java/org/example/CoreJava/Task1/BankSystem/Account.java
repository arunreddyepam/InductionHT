package org.example.CoreJava.Task1.BankSystem;

public abstract class Account {
    protected String accountNumber;
    protected double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);

    public double checkBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
