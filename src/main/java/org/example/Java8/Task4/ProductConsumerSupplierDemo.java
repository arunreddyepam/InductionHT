package org.example.Java8.Task4;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class ProductConsumerSupplierDemo {

    public static void main(String[] args) {

        List<Product> products = new ArrayList<>(Arrays.asList(
                new Product("Laptop", 50000, "Electronics", "Standard"),
                new Product("Phone", 1200, "Electronics", "Standard"),
                new Product("Book", 300, "Books", "Standard"),
                new Product("TV", 3500, "Electronics", "Standard"),
                new Product("Pen", 20, "Stationery", "Standard")
        ));

        // 1. Consumer to print product to file or console
        BiConsumer<Product, String> printProduct = (product, printMedium) -> {
            if ("file".equalsIgnoreCase(printMedium)) {
                try (FileWriter fw = new FileWriter("product_log.txt", true)) {
                    fw.write(product.toString() + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println(product);
            }
        };

        // Example usage:
        System.out.println("Printing Laptop to file and Book to console:");
        printProduct.accept(products.get(0), "file");
        printProduct.accept(products.get(2), "console");

        // 2. Consumer to update grade to 'Premium' if price > 1000, then print all
        Consumer<Product> updateGrade = product -> {
            if (product.price > 1000) {
                product.grade = "Premium";
            }
        };
        products.forEach(updateGrade);
        System.out.println("\nAll products after updating grade:");
        products.forEach(System.out::println);

        // 3. Consumer to suffix name with '*' if price > 3000, then print all
        Consumer<Product> suffixName = product -> {
            if (product.price > 3000) {
                product.name = product.name + "*";
            }
        };
        products.forEach(suffixName);
        System.out.println("\nAll products after suffixing name:");
        products.forEach(System.out::println);

        // 4. Print all Premium grade products with name suffixed with '*'
        System.out.println("\nPremium grade products with name suffixed with '*':");
        products.stream()
                .filter(p -> "Premium".equals(p.grade) && p.name.endsWith("*"))
                .forEach(System.out::println);

        // 5. Supplier to produce a random product
        Supplier<Product> randomProductSupplier = () -> {
            String[] names = {"Tablet", "Monitor", "Speaker", "Camera"};
            String[] categories = {"Electronics", "Gadgets", "Accessories"};
            Random rand = new Random();
            String name = names[rand.nextInt(names.length)];
            double price = 100 + rand.nextInt(5000);
            String category = categories[rand.nextInt(categories.length)];
            String grade = "Standard";
            return new Product(name, price, category, grade);
        };
        System.out.println("\nRandom product: " + randomProductSupplier.get());

        // 6. Supplier to produce a random OTP
        Supplier<String> otpSupplier = () -> {
            Random rand = new Random();
            int otp = 100000 + rand.nextInt(900000); // 6-digit OTP
            return String.valueOf(otp);
        };
        System.out.println("Random OTP: " + otpSupplier.get());
    }
}