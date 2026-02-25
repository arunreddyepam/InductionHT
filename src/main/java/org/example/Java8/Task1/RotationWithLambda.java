package org.example.Java8.Task1;

import java.util.function.BiPredicate;

public class RotationWithLambda {
    public static void main(String[] args) {
        BiPredicate<String, String> isRotation =
                (s1, s2) -> s1.length() == s2.length() &&
                        (s1 + s1).contains(s2);

        System.out.println(isRotation.test("ABCD", "CDAB"));
    }
}