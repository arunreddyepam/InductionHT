package org.example.CoreJava;

// Abstract Account class
abstract class Account {
    protected String accountNumber;
    protected double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public abstract void withdraw(double amount);

    public void checkBalance() {
        System.out.println("Account Number: " + accountNumber + ", Balance: " + balance);
    }
}

// SavingsAccount with interest calculation
class SavingsAccount extends Account {
    private double interestRate; // e.g., 0.03 for 3% annual

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid or insufficient funds for withdrawal.");
        }
    }

    public void addInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("Interest added: " + interest);
    }
}

// CheckingAccount with transaction limit
class CheckingAccount extends Account {
    private int transactionLimit;
    private int transactions;

    public CheckingAccount(String accountNumber, double balance, int transactionLimit) {
        super(accountNumber, balance);
        this.transactionLimit = transactionLimit;
        this.transactions = 0;
    }

    @Override
    public void withdraw(double amount) {
        if (transactions >= transactionLimit) {
            System.out.println("Transaction limit reached.");
            return;
        }
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions++;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid or insufficient funds for withdrawal.");
        }
    }

    @Override
    public void deposit(double amount) {
        if (transactions >= transactionLimit) {
            System.out.println("Transaction limit reached.");
            return;
        }
        super.deposit(amount);
        transactions++;
    }

    public void resetTransactions() {
        transactions = 0;
        System.out.println("Transaction count reset.");
    }
}

// Main class to test the system
public class BankSystem {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("SA123", 1000, 0.03);
        CheckingAccount ca = new CheckingAccount("CA456", 500, 3);

        sa.deposit(200);
        sa.withdraw(100);
        sa.addInterest();
        sa.checkBalance();

        ca.deposit(100);
        ca.withdraw(50);
        ca.withdraw(30);
        ca.withdraw(20); // Should hit transaction limit
        ca.checkBalance();
        ca.resetTransactions();
        ca.deposit(50); // Should work after reset
        ca.checkBalance();
    }
}