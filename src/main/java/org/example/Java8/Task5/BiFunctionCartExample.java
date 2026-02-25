package org.example.Java8.Task5;

import org.example.Java8.Task4.ProductClass;

import java.util.*;
import java.util.function.BiFunction;

public class BiFunctionCartExample {
    public static void main(String[] args) {

        BiFunction<String, Double, ProductClass> createProduct =
                (name, price) -> new ProductClass(name, price, "General", 'A');


        ProductClass laptop = createProduct.apply("Laptop", 75000.0);
        ProductClass mouse = createProduct.apply("Mouse", 500.0);


        BiFunction<ProductClass, Integer, Double> calculateCost =
                (product, quantity) -> product.price * quantity;


        Map<ProductClass, Integer> cart = new HashMap<>();
        cart.put(laptop, 2); // 2 laptops
        cart.put(mouse, 5);  // 5 mice


        double totalCost = cart.entrySet().stream()
                .mapToDouble(entry -> calculateCost.apply(entry.getKey(), entry.getValue()))
                .sum();

        System.out.println("Total cart cost: " + totalCost);
    }
}
