package org.example.DesignPatterns.StrategyPattern;

public class EmailShare implements ShareStrategy {

    @Override
    public void share(String photo) {
        System.out.println("Sharing " + photo + " via Email");
    }
}
