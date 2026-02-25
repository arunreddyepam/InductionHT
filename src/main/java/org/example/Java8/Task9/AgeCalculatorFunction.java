package org.example.Java8.Task9;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

public class AgeCalculatorFunction {
    public static void main(String[] args) {
        Function<LocalDate, Integer> calculateAge = dob -> {
            LocalDate today = LocalDate.now();
            return Period.between(dob, today).getYears();
        };

        // Example usage
        LocalDate dob = LocalDate.of(1995, 2, 25);
        System.out.println("Age: " + calculateAge.apply(dob));
    }
}
