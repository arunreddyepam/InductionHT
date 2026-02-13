package org.example.OOPs;
import java.util.ArrayList;
import java.util.List;
// Class to represent a Flower
class Flower {
    private String name;
    private double cost;

    public Flower(String name, double cost) {
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

// Class to represent a Bouquet

class Bouquet {
    private List<Flower> flowers; // List of flowers in the bouquet

    public Bouquet() {
        this.flowers = new ArrayList<>(); // Initialize the list of flowers
    }

    // Method to add a flower to the bouquet
    public void addFlower(Flower flower) {
        flowers.add(flower);
    }

    // Method to calculate the total cost of the bouquet
    public double calculateCost() {
        double totalCost = 0;
        for (Flower flower : flowers) {
            totalCost += flower.getCost();
        }
        return totalCost;
    }

    @Override
    public String toString() {
        StringBuilder bouquetDescription = new StringBuilder();
        if (flowers.isEmpty()) {
            bouquetDescription.append("No flowers");
        } else {
            for (Flower flower : flowers) {
                bouquetDescription.append(flower.getName()).append(", ");
            }
            // Remove the trailing ", "
            bouquetDescription.setLength(bouquetDescription.length() - 2);
        }

        return "Bouquet with Flowers: " + bouquetDescription +
                ". Total Cost: $" + calculateCost();
    }
}

// Main class to demonstrate the functionality
class FlowerShop {
    public static void main(String[] args) {
        // Define individual flowers
        Flower rose = new Flower("Rose", 1.00);
        Flower jasmine = new Flower("Jasmine", 2.00);
        Flower lily = new Flower("Lily", 3.00);

        // Create a bouquet
        Bouquet myBouquet = new Bouquet();
        myBouquet.addFlower(rose);
        myBouquet.addFlower(jasmine);
        myBouquet.addFlower(lily);

        // Display bouquet details
        System.out.println(myBouquet);

        // Create another bouquet
        Bouquet anotherBouquet = new Bouquet();
        anotherBouquet.addFlower(rose);
        anotherBouquet.addFlower(rose);
        anotherBouquet.addFlower(jasmine);

        // Display the second bouquet details
        System.out.println(anotherBouquet);
    }
}