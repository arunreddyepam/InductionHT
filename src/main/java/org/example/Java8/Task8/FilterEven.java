package org.example.Java8.Task8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterEven {
    public static void main(String[] args){
        List<Integer> numbers = Arrays.asList(2,8,5,9,11,4);
        List<Integer> filterEvenNumbers = numbers.stream().filter(n->(n%2==0)).collect(Collectors.toList());
        System.out.println(filterEvenNumbers);
    }
}
