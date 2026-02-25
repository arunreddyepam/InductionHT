package org.example.Java8.Task1;

import java.util.TreeSet;

public class TreeSetReverseOrderWithLambda {
    public static void main(String[] args) {
        TreeSet<Integer> numbers = new TreeSet<>((a, b) -> b - a);
        numbers.add(10);
        numbers.add(5);
        numbers.add(20);
        numbers.add(1);

        System.out.println(numbers);
    }
}
