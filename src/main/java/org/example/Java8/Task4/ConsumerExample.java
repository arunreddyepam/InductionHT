package org.example.Java8.Task4;

import java.io.FileWriter;
import java.io.IOException;
import java.util.function.Consumer;

public class ConsumerExample {

    public static void main(String[] args) {

        ProductClass product = new ProductClass("Laptop", 75000, "Electronics", 'A');

        boolean printToFile = true; // change to false to print on console

        Consumer<ProductClass> productConsumer = p -> {
            if (printToFile) {
                try (FileWriter writer = new FileWriter("products.txt", true)) {
                    writer.write(p.toString() + System.lineSeparator());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println(p);
            }
        };

        productConsumer.accept(product);
    }
}
