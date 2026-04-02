package org.example.Collections.Task6;

import java.util.*;

public class HashMapDemo {
    public static void main(String[] args) {

        // 1. Create and put key-value pairs
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 95);
        scores.put("Bob",   78);
        scores.put("Carol", 88);
        scores.put("Alice", 99); // overwrites existing key
        scores.put(null,    0);  // allows one null key

        System.out.println("Map: " + scores);
        // 2. Access values
        System.out.println("Alice's score : " + scores.get("Alice"));
        System.out.println("Dave (missing): " + scores.get("Dave")); // null
        System.out.println("Dave default  : " + scores.getOrDefault("Dave", 0));

        // 3. Check presence
        System.out.println("Has Bob  : " + scores.containsKey("Bob"));
        System.out.println("Has score 88: " + scores.containsValue(88));

        // 4. Merge / compute
        scores.putIfAbsent("Dave", 70); // only if key missing
        scores.merge("Bob", 5, Integer::sum); // Bob += 5
        scores.compute("Carol", (k, v) -> v + 10); // Carol += 10

        // 5. Iterate key-value pairs
        for (Map.Entry<String, Integer> e : scores.entrySet()) {
            System.out.printf("  %-6s -> %d%n", e.getKey(), e.getValue());
        }
        // 6. Keys and Values collections
        System.out.println("Keys  : " + scores.keySet());
        System.out.println("Values: " + scores.values());

        // 7. Remove and size
        scores.remove("Bob");
        System.out.println("Size after remove: " + scores.size());
    }
}
