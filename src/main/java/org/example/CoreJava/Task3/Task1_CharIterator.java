package org.example.CoreJava.Task3;

import java.util.Scanner;

public class Task1_CharIterator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        System.out.println("Characters in the string:");
        for (int i = 0; i < input.length(); i++) {
            System.out.println(input.charAt(i));
        }
        scanner.close();
    }
}