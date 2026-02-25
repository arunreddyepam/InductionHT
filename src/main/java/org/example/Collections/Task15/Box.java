package org.example.Collections.Task15;

import java.math.BigDecimal;

public class Box {

    private static int counter = 0;

    private final int id;
    private final String sender;
    private final String recipient;
    private final double weight;
    private final double volume;
    private final BigDecimal cost;
    private final String city;
    private final int office;

    public Box(String sender,
               String recipient,
               double weight,
               double volume,
               BigDecimal cost,
               String city,
               int office) {

        this.id = ++counter;
        this.sender = sender;
        this.recipient = recipient;
        this.weight = weight;
        this.volume = volume;
        this.cost = cost;
        this.city = city;
        this.office = office;
    }

    public int getId() {
        return id;
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

    @Override
    public String toString() {
        return "Box{" +
                "id=" + id +
                ", sender='" + sender + '\'' +
                ", recipient='" + recipient + '\'' +
                ", weight=" + weight +
                ", volume=" + volume +
                ", cost=" + cost +
                ", city='" + city + '\'' +
                ", office=" + office +
                '}';
    }
}

