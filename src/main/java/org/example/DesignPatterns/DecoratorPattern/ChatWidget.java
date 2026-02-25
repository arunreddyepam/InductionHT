package org.example.DesignPatterns.DecoratorPattern;

public class ChatWidget extends WidgetDecorator {

    public ChatWidget(WebPage page) {
        super(page);
    }

    @Override
    public int getRank() {
        return super.getRank() + 10;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Chat Widget";
    }
}