package org.example.DesignPatterns.StrategyPattern;

public class TextShare implements ShareStrategy {

    @Override
    public void share(String photo) {
        System.out.println("Sharing " + photo + " via Text Message");
    }
}