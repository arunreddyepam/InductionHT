package org.example.CoreJava.Task3;

import java.util.Scanner;

public class CharCountDoWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get string input from user
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Get character to search for
        System.out.print("Enter the character to count: ");
        char searchChar = scanner.nextLine().charAt(0);

        // Convert both string and character to lower case for case-insensitive search
        String lowerInput = input.toLowerCase();
        char lowerChar = Character.toLowerCase(searchChar);

        int count = 0;
        int i = 0;

        // Use do-while loop to count occurrences
        if (lowerInput.length() > 0) {
            do {
                if (lowerInput.charAt(i) == lowerChar) {
                    count++;
                }
                i++;
            } while (i < lowerInput.length());
        }

        System.out.println("The character '" + searchChar + "' appears " + count + " times (case-insensitive).");
    }
}