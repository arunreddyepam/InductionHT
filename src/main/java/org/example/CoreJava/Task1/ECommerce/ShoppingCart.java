package org.example.CoreJava.Task1.ECommerce;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> products;

    public ShoppingCart() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Added product: " + product.getProductId());
    }

    public void removeProduct(String productId) {
        products.removeIf(p -> p.getProductId().equals(productId));
        System.out.println("Removed product: " + productId);
    }

    public double calculateTotal() {
        double total = 0;
        for (Product p : products) {
            total += p.getFinalPrice();
        }
        return total;
    }

    public void showCart() {
        for (Product p : products) {
            System.out.println("Product: " + p.getProductId() + ", Price: " + p.getFinalPrice());
        }
    }
}