package org.example.BDD;

public class CashDispenser {
    private int dispensedAmount = 0;

    public void dispense(int amount) {
        dispensedAmount = amount;
    }

    public int getDispensedAmount() {

        return dispensedAmount; }
}