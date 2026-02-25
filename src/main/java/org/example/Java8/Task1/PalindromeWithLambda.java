package org.example.Java8.Task1;

import java.util.function.Predicate;

public class PalindromeWithLambda {
    public static void main(String[] args) {
        Predicate<String> isPalindrome = s ->
                s.equals(new StringBuilder(s).reverse().toString());

        System.out.println(isPalindrome.test("madam"));
    }
}
