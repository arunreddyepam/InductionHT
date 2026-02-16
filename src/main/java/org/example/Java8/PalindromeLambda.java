package org.example.Java8;

import java.util.Scanner;

public class PalindromeLambda {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Lambda expression to check palindrome
        PalindromeChecker isPalindrome = (str) -> {
            String cleaned = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            int len = cleaned.length();
            for (int i = 0; i < len / 2; i++) {
                if (cleaned.charAt(i) != cleaned.charAt(len - 1 - i)) {
                    return false;
                }
            }
            return true;
        };

        if (isPalindrome.check(input)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a palindrome");
        }
    }
}

// Functional interface for palindrome checking
@FunctionalInterface
interface PalindromeChecker {
    boolean check(String str);
}
