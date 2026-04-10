package org.example.CoreJava.Task1.BankSystem;

public class CheckingAccount extends Account {
    private int transactionLimit;
    private int transactions;

    public CheckingAccount(String accountNumber, double balance, int transactionLimit) {
        super(accountNumber, balance);
        this.transactionLimit = transactionLimit;
        this.transactions = 0;
    }

    @Override
    public void deposit(double amount) {
        if (transactions >= transactionLimit) {
            System.out.println("Transaction limit reached.");
            return;
        }
        if (amount > 0) {
            balance += amount;
            transactions++;
            System.out.println("Deposited " + amount + " to CheckingAccount " + accountNumber);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (transactions >= transactionLimit) {
            System.out.println("Transaction limit reached.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            transactions++;
            System.out.println("Withdrew " + amount + " from CheckingAccount " + accountNumber);
        }
    }

    public void resetTransactions() {
        transactions = 0;
        System.out.println("Transaction count reset for CheckingAccount " + accountNumber);
    }
}

