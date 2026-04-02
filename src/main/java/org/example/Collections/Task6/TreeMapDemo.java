package org.example.Collections.Task6;

import java.util.*;

public class TreeMapDemo {
    public static void main(String[] args) {

        // 1. Keys automatically sorted in natural order
        TreeMap<String, Integer> pop = new TreeMap<>();
        pop.put("Mumbai",    20);
        pop.put("Hyderabad", 10);
        pop.put("Delhi",     32);
        pop.put("Bangalore", 12);
        pop.put("Chennai",   11);
        System.out.println("TreeMap: " + pop);
        // Sorted by key: {Bangalore=12, Chennai=11, Delhi=32, ...}

        // 2. First and last key
        System.out.println("First key: " + pop.firstKey());
        System.out.println("Last key : " + pop.lastKey());
        // 3. Navigation: floor / ceiling / lower / higher keys
        System.out.println("FloorKey(E)  : " + pop.floorKey("E")); // Delhi
        System.out.println("CeilingKey(E): " + pop.ceilingKey("E"));// Hyderabad
        System.out.println("LowerKey(D)  : " + pop.lowerKey("Delhi"));  // Chennai
        System.out.println("HigherKey(D) : " + pop.higherKey("Delhi")); // Hyderabad

        // 4. Sub-map views
        System.out.println("SubMap (C..H): " +
                pop.subMap("C", true, "H", false));
        System.out.println("HeadMap (<=C): " + pop.headMap("D"));
        System.out.println("TailMap (>=M): " + pop.tailMap("M"));

        // 5. Poll first/last entries
        Map.Entry<String, Integer> first = pop.pollFirstEntry();
        System.out.println("Removed first: " + first);
        // 6. Descending map view
        System.out.println("Descending: " + pop.descendingMap());

        // 7. Custom comparator (by value using entrySet sort)
        TreeMap<String, Integer> byLen = new TreeMap<>(
                Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()));
        byLen.putAll(pop);
        System.out.println("By key length: " + byLen.keySet());

        // 8. Compute value if absent
        pop.computeIfAbsent("Pune", k -> 7);
        System.out.println("After add Pune: " + pop);
    }
}
