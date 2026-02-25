package org.example.CoreJava.Task4;

import java.util.Scanner;

public class MatrixOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get dimensions for first matrix
        System.out.print("Enter rows for Matrix 1: ");
        int rows1 = scanner.nextInt();
        System.out.print("Enter columns for Matrix 1: ");
        int cols1 = scanner.nextInt();

        // Get dimensions for second matrix
        System.out.print("Enter rows for Matrix 2: ");
        int rows2 = scanner.nextInt();
        System.out.print("Enter columns for Matrix 2: ");
        int cols2 = scanner.nextInt();

        // Initialize matrices
        int[][] matrix1 = new int[rows1][cols1];
        int[][] matrix2 = new int[rows2][cols2];

        // Input elements for matrix 1
        System.out.println("Enter elements for Matrix 1:");
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols1; j++) {
                matrix1[i][j] = scanner.nextInt();
            }
        }

        // Input elements for matrix 2
        System.out.println("Enter elements for Matrix 2:");
        for (int i = 0; i < rows2; i++) {
            for (int j = 0; j < cols2; j++) {
                matrix2[i][j] = scanner.nextInt();
            }
        }

        // User choice: addition or multiplication
        System.out.print("Enter '1' for Addition or '2' for Multiplication: ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            // Addition: dimensions must match
            if (rows1 == rows2 && cols1 == cols2) {
                int[][] sum = new int[rows1][cols1];
                for (int i = 0; i < rows1; i++) {
                    for (int j = 0; j < cols1; j++) {
                        sum[i][j] = matrix1[i][j] + matrix2[i][j];
                    }
                }
                System.out.println("Result of Addition:");
                printMatrix(sum);
            } else {
                System.out.println("Addition not possible: Matrices must have the same dimensions.");
            }
        } else if (choice == 2) {
            // Multiplication: cols1 must equal rows2
            if (cols1 == rows2) {
                int[][] product = new int[rows1][cols2];
                for (int i = 0; i < rows1; i++) {
                    for (int j = 0; j < cols2; j++) {
                        product[i][j] = 0;
                        for (int k = 0; k < cols1; k++) {
                            product[i][j] += matrix1[i][k] * matrix2[k][j];
                        }
                    }
                }
                System.out.println("Result of Multiplication:");
                printMatrix(product);
            } else {
                System.out.println("Multiplication not possible: Columns of Matrix 1 must equal rows of Matrix 2.");
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }

    // Helper method to print a matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }
}
