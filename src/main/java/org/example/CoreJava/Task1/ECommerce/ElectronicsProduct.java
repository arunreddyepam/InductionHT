package org.example.CoreJava.Task1.ECommerce;

public class ElectronicsProduct extends Product {
    private double warrantyFee;

    public ElectronicsProduct(String productId, double price, int quantityOnHand, double warrantyFee) {
        super(productId, price, quantityOnHand);
        this.warrantyFee = warrantyFee;
    }

    @Override
    public double getFinalPrice() {
        return price + warrantyFee;
    }
}
