package org.example.Java8.Task1;

import java.util.TreeMap;

public class TreeMapEmployeeDescNameWithLambda {
    public static void main(String[] args) {
        TreeMap<Employee, Integer> map = new TreeMap<>((e1, e2) -> e2.getName().compareTo(e1.getName()));
        map.put(new Employee(3,"John"),100);
        map.put(new Employee(1,"Alice"),200);
        map.put(new Employee(2,"Bob"),150);

        System.out.println(map);
    }
}