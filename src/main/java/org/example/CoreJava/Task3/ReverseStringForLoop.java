package org.example.CoreJava.Task3;

import java.util.Scanner;

public class ReverseStringForLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get string input from user
        System.out.print("Enter a string to reverse: ");
        String input = scanner.nextLine();

        String reversed = "";

        // Use for loop to reverse the string
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }

        // Handle single-character and empty string gracefully
        if (input.length() == 0) {
            System.out.println("You entered an empty string.");
        } else {
            System.out.println("Reversed string: " + reversed);
        }
    }
}
