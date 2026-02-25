package org.example.Collections.Task13;

public class Main {
    public static void main(String[] args) {
        HashtableOpen8to16 table = HashtableOpen8to16.getInstance();

        table.insert(1, "A");
        table.insert(9, "B"); // collision if capacity 8
        table.insert(17, "C");

        System.out.println(table.search(1));   // A
        System.out.println(table.search(9));   // B
        System.out.println(table.search(17));  // C

        table.remove(9);
        System.out.println(table.search(9));   // null

        int[] keys = table.keys();
        for (int k : keys) {
            System.out.println("Key: " + k);
        }
    }
}

