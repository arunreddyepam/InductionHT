package org.example.Java8.Task3;

import java.util.*;
import java.util.function.Function;

public class ProductCostCalculatorWithLambda {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", 1000.0, "Electronics", "A"),
                new Product("Phone", 500.0, "Electronics", "B"),
                new Product("Book", 30.0, "Stationery", "A")
        );

        Function<List<Product>, Double> totalCostFunction = productList ->
                productList.stream().mapToDouble(Product::getPrice).sum();

        double totalCost = totalCostFunction.apply(products);
        System.out.println("Total cost: " + totalCost);
    }
}