package org.example.BDD;

public class BankAccount implements Account{
    private int balance;

    public BankAccount(int balance){
        this.balance=balance;

    }

    @Override
    public int getBalance() {
        return balance;
    }

    public void withdraw(int amount){
        if(amount<=balance){
            balance=balance-amount;
        }
        else {
            throw new IllegalArgumentException("balance insufficient");
        }
    }
}
