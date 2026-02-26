package org.example.OOPs;

import java.util.ArrayList;
import java.util.List;
// Class to represent a Pizza Base
public class PizzaBase {
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

// Class to represent a Pizza


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