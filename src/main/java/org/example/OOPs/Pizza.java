package org.example.OOPs;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private PizzaBase base; // The base for the pizza
    private List<Topping> toppings; // A list of toppings

    public Pizza(PizzaBase base) {
        this.base = base;
        this.toppings = new ArrayList<>(); // Initialize the list of toppings
    }

    // Method to add a topping to the pizza
    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    // Method to calculate the total cost of the pizza
    public double calculateCost() {
        double totalCost = base.getCost();
        for (Topping topping : toppings) {
            totalCost += topping.getCost();
        }
        return totalCost;
    }

    @Override
    public String toString() {
        StringBuilder toppingsStr = new StringBuilder();
        if (toppings.isEmpty()) {
            toppingsStr.append("No toppings");
        } else {
            for (Topping topping : toppings) {
                toppingsStr.append(topping.getName()).append(", ");
            }
            // Remove the trailing ", "
            toppingsStr.setLength(toppingsStr.length() - 2);
        }

        return "Pizza with " + base.getName() + " Base and Toppings: " + toppingsStr +
                ". Total Cost: $" + calculateCost();
    }
}
