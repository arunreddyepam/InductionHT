package org.example.CoreJava;

import java.util.Scanner;

public class NumberPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of levels: ");
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            // Print spaces for centering
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }
            // Print increasing numbers
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            // Print decreasing numbers
            for (int j = i - 1; j >= 1; j--) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}