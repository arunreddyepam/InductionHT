package org.example.Collections.Task6;

import java.util.*;

public class HashSetDemo {
    public static void main(String[] args) {

        // 1. Create and add (duplicates silently ignored)
        Set<String> colors = new HashSet<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        boolean added = colors.add("Red"); // duplicate -> returns false
        System.out.println("Set    : " + colors);
        System.out.println("Added dup: " + added); // false

        // 2. Contains check - O(1)
        System.out.println("Has Blue : " + colors.contains("Blue"));
        System.out.println("Has Pink : " + colors.contains("Pink"));
// 3. Remove element
        colors.remove("Green");
        System.out.println("After remove: " + colors);

        // 4. Set operations using two sets
        Set<Integer> a = new HashSet<>(Arrays.asList(1,2,3,4,5));
        Set<Integer> b = new HashSet<>(Arrays.asList(4,5,6,7));

        // Union: a | b
        Set<Integer> union = new HashSet<>(a);
        union.addAll(b);
        System.out.println("Union      : " + union);

        // Intersection: a & b
        Set<Integer> inter = new HashSet<>(a);
        inter.retainAll(b);
        System.out.println("Intersection: " + inter);
// Difference: a - b
        Set<Integer> diff = new HashSet<>(a);
        diff.removeAll(b);
        System.out.println("Difference : " + diff);

        // 5. Subset check
        System.out.println("b subset of union: " + union.containsAll(b));

        // 6. Iterate (order not guaranteed)
        for (Integer n : a) System.out.print(n + " ");
    }
}
