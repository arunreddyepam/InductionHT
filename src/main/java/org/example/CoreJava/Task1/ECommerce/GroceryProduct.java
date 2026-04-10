package org.example.CoreJava.Task1.ECommerce;

public class GroceryProduct extends Product {
    private double discount;

    public GroceryProduct(String productId, double price, int quantityOnHand, double discount) {
        super(productId, price, quantityOnHand);
        this.discount = discount;
    }

    @Override
    public double getFinalPrice() {
        return price - discount;
    }
}
