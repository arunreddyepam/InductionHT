package org.example.Java8.Task9;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.function.Supplier;

public class NextThursdaySupplier {
    public static void main(String[] args) {
        Supplier<LocalDate> nextThursday = () ->
                LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.THURSDAY));

        // Example usage
        System.out.println("Next Thursday: " + nextThursday.get());
    }
}