package org.example.Java8.Task4;

public class  ProductClass {
    String name;
    double price;
    String category;
    char grade;

    public ProductClass(String name, double price, String category, char grade) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", grade=" + grade +
                '}';
    }
}