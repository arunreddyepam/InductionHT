package org.example.Java8.Task1;

import java.util.*;

public class SecondBiggestWithLambda {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 40, 20, 50, 30);

        int secondBiggest = list.stream()
                .sorted((a, b) -> b - a)
                .skip(1)
                .findFirst()
                .get();

        System.out.println(secondBiggest);
    }
}
