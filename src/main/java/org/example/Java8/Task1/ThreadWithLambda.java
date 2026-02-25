package org.example.Java8.Task1;

public class ThreadWithLambda {
    public static void main(String[] args) {
        Runnable r = () -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println(i);
            }
        };

        new Thread(r).start();
    }
}