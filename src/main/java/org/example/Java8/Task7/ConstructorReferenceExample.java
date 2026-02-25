package org.example.Java8.Task7;

public class ConstructorReferenceExample {

    public static void main(String[] args) {

        EmployeeFactory factory = EmployeeClass::new;

        EmployeeClass emp = factory.create("Soujanya", "ACC12345", 75000);

        System.out.println(emp);
    }
}
