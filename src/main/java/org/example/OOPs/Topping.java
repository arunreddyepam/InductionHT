package org.example.OOPs;

// Class to represent a Topping
public class Topping {
    private String name;
    private double cost;

    public Topping(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return name + ": $" + cost;
    }
}
