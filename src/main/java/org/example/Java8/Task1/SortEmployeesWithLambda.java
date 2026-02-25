package org.example.Java8.Task1;

import java.util.ArrayList;
import java.util.List;

public class SortEmployeesWithLambda {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(3,"John"));
        employees.add(new Employee(1,"Alice"));
        employees.add(new Employee(2,"Bob"));

        employees.sort((e1, e2) -> e1.getName().compareTo(e2.getName()));

        for (Employee e : employees) {
            System.out.println(e);
        }
    }
}