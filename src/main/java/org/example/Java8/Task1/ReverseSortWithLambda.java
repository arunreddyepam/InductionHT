package org.example.Java8.Task1;

import java.util.*;

public class ReverseSortWithLambda {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 2, 9, 1);

        Collections.sort(list, (a, b) -> b - a);

        System.out.println(list);
    }
}