package org.example.Java8.Task1;

import java.util.TreeSet;

public class TreeSetEmployeeByNameWithLambda {
    public static void main(String[] args) {
        TreeSet<Employee> employees = new TreeSet<>((e1, e2) -> e1.getName().compareTo(e2.getName()));
        employees.add(new Employee(3,"John"));
        employees.add(new Employee(1,"Alice"));
        employees.add(new Employee(2,"Bob"));

        System.out.println(employees);
    }
}
