package org.example.Java8.Task5;

import org.example.Java8.Task4.Product;

import java.util.*;
import java.util.function.BiFunction;

public class BiFunctionCartExample {
    public static void main(String[] args) {

        BiFunction<String, Double, Product> createProduct =
                (name, price) -> new Product(name, price, "General", "A");


        Product laptop = createProduct.apply("Laptop", 75000.0);
        Product mouse = createProduct.apply("Mouse", 500.0);


        BiFunction<Product, Integer, Double> calculateCost =
                (product, quantity) -> product.price * quantity;


        Map<Product, Integer> cart = new HashMap<>();
        cart.put(laptop, 2); // 2 laptops
        cart.put(mouse, 5);  // 5 mice


        double totalCost = cart.entrySet().stream()
                .mapToDouble(entry -> calculateCost.apply(entry.getKey(), entry.getValue()))
                .sum();

        System.out.println("Total cart cost: " + totalCost);
    }
}
