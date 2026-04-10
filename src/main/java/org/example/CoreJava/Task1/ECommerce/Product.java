package org.example.CoreJava.Task1.ECommerce;

public abstract class Product {
    protected String productId;
    protected double price;
    protected int quantityOnHand;

    public Product(String productId, double price, int quantityOnHand) {
        this.productId = productId;
        this.price = price;
        this.quantityOnHand = quantityOnHand;
    }

    public String getProductId() {
        return productId;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantityOnHand() {
        return quantityOnHand;
    }

    // Polymorphic method for price calculation (can be overridden)
    public double getFinalPrice() {
        return price;
    }
}