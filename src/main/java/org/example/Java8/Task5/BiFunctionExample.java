package org.example.Java8.Task5;

import org.example.Java8.Task4.ProductClass;

import java.util.function.BiFunction;

public class BiFunctionExample {

    public static void main(String[] args) {

        BiFunction<String, Double, ProductClass> createProduct =
                (name, price) -> new ProductClass(name, price, "General", 'A');

        ProductClass product = createProduct.apply("Laptop", 75000.0);

        System.out.println(product);
    }
}
