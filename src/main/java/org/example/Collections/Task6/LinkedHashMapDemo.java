package org.example.Collections.Task6;

import java.util.*;

public class LinkedHashMapDemo {
    public static void main(String[] args) {

        // Storing a student's subject marks — order matters!
        Map<String, Integer> marks = new LinkedHashMap<>();

        marks.put("Maths",   92);
        marks.put("Science", 85);
        marks.put("English", 78);
        marks.put("History", 88);
        marks.put("Maths",   95); // update existing key

        // Iterating — always in insertion order
        System.out.println("Subject Marks:");
        for (Map.Entry<String, Integer> entry : marks.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }

        // Total marks
        int total = marks.values().stream().mapToInt(Integer::intValue).sum();
        System.out.println("Total: " + total);

        // Check and update
        System.out.println("Has Physics: " + marks.containsKey("Physics"));
        marks.remove("History");
        System.out.println("After remove: " + marks);
    }
}
