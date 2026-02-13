package org.example.OOPs;

import java.util.ArrayList;
import java.util.List;
// Class to represent a Pizza Base
class PizzaBase {
    private String name;
    private double cost;

    public PizzaBase(String name, double cost) {
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
        return name + " Base: $" + cost;
    }
}

// Class to represent a Topping
class Topping {
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

// Class to represent a Pizza


class Pizza {
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

// Main class to demonstrate the functionality
class PizzaShop {
    public static void main(String[] args) {
        // Define Pizza Bases
        PizzaBase standardBase = new PizzaBase("Standard", 5.00);
        PizzaBase softBase = new PizzaBase("Soft", 6.00);

        // Define Toppings
        Topping tomato = new Topping("Tomato", 1.00);
        Topping corn = new Topping("Corn", 0.50);
        Topping mushrooms = new Topping("Mushrooms", 1.50);

        // Create a Pizza
        Pizza myPizza = new Pizza(standardBase);
        myPizza.addTopping(tomato);
        myPizza.addTopping(corn);

        // Display Pizza Details
        System.out.println(myPizza);

        // Create another Pizza
        Pizza anotherPizza = new Pizza(softBase);
        anotherPizza.addTopping(mushrooms);

        // Display the second pizza
        System.out.println(anotherPizza);
    }
}