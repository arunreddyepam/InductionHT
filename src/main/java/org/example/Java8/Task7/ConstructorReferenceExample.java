package org.example.Java8.Task7;

public class ConstructorReferenceExample {

    public static void main(String[] args) {

        EmployeeFactory factory = EmployeeClass::new;

        EmployeeClass emp = factory.create("Arun Reddy", "1234567", 80000);

        System.out.println(emp);
    }
}
