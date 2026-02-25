package org.example.CoreJava.Task6;

public class ChocolatePackage {
    public static int makeChocolate(int small, int big, int goal) {
        int maxBigBars = goal / 5;
        int bigBarsToUse = Math.min(big, maxBigBars);

        int remaining = goal - (bigBarsToUse * 5);
        if (remaining <= small) {
            return remaining;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(makeChocolate(4, 1, 9));  // Output: 4
        System.out.println(makeChocolate(4, 1, 10)); // Output: -1
        System.out.println(makeChocolate(4, 1, 7));  // Output: 2
    }
}