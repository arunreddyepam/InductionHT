package org.example.Java8.Task4;

public class Product {
    String name;
    double price;
    String category;
    String grade;

    public Product(String name, double price, String category, String grade) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price +
                ", category='" + category + "', grade='" + grade + "'}";
    }
}