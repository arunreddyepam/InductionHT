package org.example.CoreJava.Task3;

import java.util.Random;
import java.util.Scanner;

public class Task2_GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int secretNumber = random.nextInt(100) + 1;
        int maxGuesses = 7;
        int guessCount = 0;
        int guess;

        System.out.println("Guess the number between 1 and 100! You have " + maxGuesses + " attempts.");

        do {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            guessCount++;

            if (guess < secretNumber) {
                System.out.println("Too low!");
            } else if (guess > secretNumber) {
                System.out.println("Too high!");
            } else {
                System.out.println("Correct! You guessed it in " + guessCount + " attempt(s)!");
                break;
            }

            int remaining = maxGuesses - guessCount;
            if (remaining > 0) {
                System.out.println("Attempts remaining: " + remaining);
            }

        } while (guessCount < maxGuesses);

        if (guess != secretNumber) {
            System.out.println("Out of attempts! The number was: " + secretNumber);
        }

        scanner.close();
    }
}
