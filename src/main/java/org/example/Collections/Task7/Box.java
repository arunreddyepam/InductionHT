package org.example.Collections.Task7;

import java.math.BigDecimal;

public class Box {
    private String sender;
    private String recipient;
    private double weight; // kg
    private double volume; // m3
    private BigDecimal shippingCost;

    // Constructor
    public Box(String sender, String recipient, double weight, double volume, int value) {
        if (sender == null || sender.isEmpty())
            throw new IllegalArgumentException("Sender must exist");
        if (recipient == null || recipient.isEmpty())
            throw new IllegalArgumentException("Recipient must exist");
        if (weight < 0.5 || weight > 20.0)
            throw new IllegalArgumentException("Weight must be between 0.5 and 20 kg");
        if (volume <= 0 || volume >= 0.25)
            throw new IllegalArgumentException("Volume must be >0 and <0.25 m3");
        if (value <= 0)
            throw new IllegalArgumentException("Value must be greater than zero");

        this.sender = sender;
        this.recipient = recipient;
        this.weight = weight;
        this.volume = volume;
        this.shippingCost = NewPostOffice.calculateCostOfBox(weight, volume, value);
    }

    // Getters
    public String getSender() { return sender; }
    public String getRecipient() { return recipient; }
    public double getWeight() { return weight; }
    public double getVolume() { return volume; }
    public BigDecimal getShippingCost() { return shippingCost; }

    // Setter for shippingCost (needed for declineCostOfBox)
    public void setShippingCost(BigDecimal shippingCost) {
        this.shippingCost = shippingCost;
    }

    @Override
    public String toString() {
        return "Box{" +
                "sender='" + sender + '\'' +
                ", recipient='" + recipient + '\'' +
                ", weight=" + weight +
                ", volume=" + volume +
                ", shippingCost=" + shippingCost +
                '}';
    }
}

