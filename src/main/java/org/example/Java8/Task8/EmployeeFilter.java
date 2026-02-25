package org.example.Java8.Task8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeFilter {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Krish",30,"Doctor",50000));
        employees.add(new Employee("Neha",35,"IT",35000));
        employees.add(new Employee("Surya",28,"IT",30000));

        List<String> names = employees.stream()
                .filter(e->e.getDepartment().equals("IT"))
                .sorted((a,b)->b.getSalary()-a.getSalary())
                .map(name->name.getName())
                .collect(Collectors.toList());
        System.out.println(names);

        List<Employee> sortedEmployee = employees.stream()
                .sorted((a,b)->a.getName().compareTo(b.getName()))
                .collect(Collectors.toList());
        System.out.println(sortedEmployee);

    }
}
