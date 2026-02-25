package org.example.CoreJava.Task6;

public class EvenlySpaced {
    public static boolean evenlySpaced(int a, int b, int c) {
        int min = Math.min(a, Math.min(b, c));
        int max = Math.max(a, Math.max(b, c));
        int mid = a + b + c - min - max;
        return (max - mid) == (mid - min);
    }

    public static void main(String[] args) {
        System.out.println(evenlySpaced(2, 4, 6)); // true
        System.out.println(evenlySpaced(4, 6, 2)); // true
        System.out.println(evenlySpaced(4, 6, 3)); // false
    }
}
