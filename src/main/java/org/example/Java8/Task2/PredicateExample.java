package org.example.Java8.Task2;

import java.util.*;
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        // Sample data
        List<Product> products = Arrays.asList(
                new Product("Laptop", 2000, "Electronics", "A"),
                new Product("Pen", 50, "Stationery", "B"),
                new Product("Phone", 800, "Electronics", "A"),
                new Product("Book", 120, "Books", "C"),
                new Product("Charger", 150, "Electronics", "B")
        );

        List<Response> responses = Arrays.asList(
                new Response("OK", 200, "JSON"),
                new Response("Bad Request", 400, "JSON"),
                new Response("Not Found", 404, "XML"),
                new Response("Unauthorized", 401, "JSON"),
                new Response("Bad Request", 400, "XML")
        );

        // 1. Predicate: price > 1000

        Predicate<Product> priceGreaterThan1000 = p -> p.price > 1000;
        System.out.println("Products with price > 1000:");
        products.stream().filter(priceGreaterThan1000).forEach(System.out::println);

        // 2. Predicate: category is Electronics
        Predicate<Product> isElectronics = p -> "Electronics".equalsIgnoreCase(p.category);
        System.out.println("\nProducts in Electronics category:");
        products.stream().filter(isElectronics).forEach(System.out::println);

        // 3. price > 100 AND category is Electronics
        System.out.println("\nProducts with price > 100 and Electronics category:");
        products.stream().filter(priceGreaterThan1000.or(p -> p.price > 100).and(isElectronics)).forEach(System.out::println);

        // 4. price > 100 OR category is Electronics
        System.out.println("\nProducts with price > 100 or Electronics category:");
        products.stream().filter(p -> p.price > 100 || isElectronics.test(p)).forEach(System.out::println);

        // 5. price < 100 AND category is Electronics
        System.out.println("\nProducts with price < 100 and Electronics category:");
        products.stream().filter(p -> p.price < 100 && isElectronics.test(p)).forEach(System.out::println);

        // 6. Predicate: status code is 400
        Predicate<Response> statusCode400 = r -> r.statusCode == 400;
        System.out.println("\nResponses with status code 400:");
        responses.stream().filter(statusCode400).forEach(System.out::println);

        // 7. Predicate: response type is JSON
        Predicate<Response> isJson = r -> "JSON".equalsIgnoreCase(r.responseType);
        System.out.println("\nResponses with response type JSON:");
        responses.stream().filter(isJson).forEach(System.out::println);

        // 8. status code 400 AND response type JSON
        System.out.println("\nResponses with status code 400 and response type JSON:");
        responses.stream().filter(statusCode400.and(isJson)).forEach(System.out::println);

        // 9. status code 400 OR response type JSON
        System.out.println("\nResponses with status code 400 or response type JSON:");
        responses.stream().filter(statusCode400.or(isJson)).forEach(System.out::println);

        // 10. status code NOT 400 AND response type JSON
        System.out.println("\nResponses with status code not 400 and response type JSON:");
        responses.stream().filter(statusCode400.negate().and(isJson)).forEach(System.out::println);
    }
}