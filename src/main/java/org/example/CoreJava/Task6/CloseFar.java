package org.example.CoreJava.Task6;

public class CloseFar {
    public static boolean closeFar(int a, int b, int c) {
        boolean bClose = Math.abs(a - b) <= 1;
        boolean cClose = Math.abs(a - c) <= 1;
        boolean bFar = Math.abs(b - c) >= 2 && Math.abs(a - c) >= 2;
        boolean cFar = Math.abs(b - c) >= 2 && Math.abs(a - b) >= 2;
        return (bClose && cFar) || (cClose && bFar);
    }

    public static void main(String[] args) {
        System.out.println(closeFar(1, 2, 10)); // true
        System.out.println(closeFar(1, 2, 3));  // false
        System.out.println(closeFar(4, 1, 3));  // true
    }
}