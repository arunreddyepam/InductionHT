package org.example.Java8.Task2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {

        List<Product> products = Arrays.asList(
                new Product("Laptop", 75000),
                new Product("Mobile", 15000),
                new Product("Pen", 50),
                new Product("Headphones", 1200),
                new Product("Notebook", 100)
        );

        Predicate<Product> priceGreaterThan1000 = product -> product.price > 1000;

        products.stream()
                .filter(priceGreaterThan1000)
                .forEach(System.out::println);
    }
}
