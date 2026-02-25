package org.example.Java8.Task9;

import java.time.LocalDate;
import java.util.function.Predicate;

public class YesterdayPredicateExample {

    public static void main(String[] args) {

        Predicate<LocalDate> isYesterday =
                date -> date.equals(LocalDate.now().minusDays(1));

        LocalDate inputDate = LocalDate.now().minusDays(1);

        System.out.println("Is Yesterday? " + isYesterday.test(inputDate));
    }
}

