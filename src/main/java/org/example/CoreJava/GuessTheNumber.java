package org.example.CoreJava;

import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1; // 1 to 100
        int guess;
        int maxTries = 7;
        int tries = 0;

        System.out.println("Guess the number (between 1 and 100)! You have " + maxTries + " tries.");

        do {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            tries++;

            if (guess < numberToGuess) {
                System.out.println("Too low!");
            } else if (guess > numberToGuess) {
                System.out.println("Too high!");
            } else {
                System.out.println("Congratulations! You guessed the number in " + tries + " tries.");
                break;
            }
        } while (tries < maxTries);

        if (guess != numberToGuess) {
            System.out.println("Sorry, you've used all your tries. The number was: " + numberToGuess);
        }
    }
}