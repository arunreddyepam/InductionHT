package org.example.CoreJava.Task6;

public class Blackjack {
    public static int blackjack(int a, int b) {
        if (a > 21 && b > 21) return 0;
        if (a > 21) return (b <= 21) ? b : 0;
        if (b > 21) return (a <= 21) ? a : 0;
        return Math.max(a, b);
    }

    public static void main(String[] args) {
        System.out.println(blackjack(19, 21)); // 21
        System.out.println(blackjack(21, 19)); // 21
        System.out.println(blackjack(19, 22)); // 19
    }
}
