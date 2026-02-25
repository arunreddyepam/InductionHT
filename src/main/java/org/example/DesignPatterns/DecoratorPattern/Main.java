package org.example.DesignPatterns.DecoratorPattern;

public class Main {

    public static void main(String[] args) {

        WebPage page = new DesktopPage();

        // Dynamically add widgets
        page = new ChatWidget(page);
        page = new PaymentWidget(page);
        page = new AnalyticsWidget(page);

        System.out.println("Page Details: " + page.getDescription());
        System.out.println("Final Rank: " + page.getRank());
    }
}
