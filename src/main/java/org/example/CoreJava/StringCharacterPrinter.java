package org.example.CoreJava;

import java.util.Scanner;

public class StringCharacterPrinter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {
            System.out.println(input.charAt(i));
        }
    }
}