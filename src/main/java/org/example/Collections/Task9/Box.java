package org.example.Collections.Task9;

import java.math.BigDecimal;

public class Box {

    private final String sender;
    private final String recipient;
    private final double weight;
    private final double volume;
    private final BigDecimal cost;
    private final String city;
    private int office;

    public Box(String sender,
               String recipient,
               double weight,
               double volume,
               BigDecimal cost,
               String city,
               int office) {

        if (sender == null || recipient == null || cost == null || city == null) {
            throw new NullPointerException();
        }

        this.sender = sender;
        this.recipient = recipient;
        this.weight = weight;
        this.volume = volume;
        this.cost = cost;
        this.city = city;
        this.office = office;
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public double getWeight() {
        return weight;
    }

    public double getVolume() {
        return volume;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public String getCity() {
        return city;
    }

    public int getOffice() {
        return office;
    }

    public void setOffice(int office) {
        this.office = office;
    }

    @Override
    public String toString() {
        return "Box{" +
                "sender='" + sender + '\'' +
                ", recipient='" + recipient + '\'' +
                ", weight=" + weight +
                ", volume=" + volume +
                ", cost=" + cost +
                ", city='" + city + '\'' +
                ", office=" + office +
                '}';
    }
}

