package org.example.CoreJava.Task1.BankSystem;

public class BankSystemDemo {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("SA123", 1000, 0.02);
        savings.deposit(500);
        savings.addInterest();
        System.out.println("Savings Balance: " + savings.checkBalance());

        CheckingAccount checking = new CheckingAccount("CA456", 500, 3);
        checking.deposit(100);
        checking.withdraw(50);
        checking.deposit(200);
        checking.deposit(100);
        System.out.println("Checking Balance: " + checking.checkBalance());
        checking.resetTransactions();
    }
}