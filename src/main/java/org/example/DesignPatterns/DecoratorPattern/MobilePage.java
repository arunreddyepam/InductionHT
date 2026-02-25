package org.example.DesignPatterns.DecoratorPattern;

public class MobilePage implements WebPage {

    @Override
    public int getRank() {
        return 50;
    }

    @Override
    public String getDescription() {
        return "Mobile Page";
    }
}
