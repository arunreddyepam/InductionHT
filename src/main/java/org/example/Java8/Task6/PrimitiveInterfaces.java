package org.example.Java8.Task6;

import java.util.Random;
import java.util.function.IntPredicate;
import java.util.function.IntConsumer;
import java.util.function.IntSupplier;

public class PrimitiveInterfaces {

    public static void main(String[] args) {

        IntPredicate isPrime = number -> {
            if (number <= 1) return false;
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0)
                    return false;
            }
            return true;
        };

        int num = 29;
        System.out.println(num + " is prime? " + isPrime.test(num));


        IntConsumer printSquare = number ->
                System.out.println("Square of " + number + " = " + (number * number));

        printSquare.accept(7);


        Random random = new Random();

        IntSupplier randomSupplier = () -> random.nextInt(5000);

        System.out.println("Random number below 5000: " + randomSupplier.getAsInt());
    }
}
