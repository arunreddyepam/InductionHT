package org.example.Collections.Task6;

import java.util.*;

public class LinkedHashSetDemo {
    public static void main(String[] args) {

        // 1. Insertion order is maintained (unlike HashSet)
        Set<String> cities = new LinkedHashSet<>();
        cities.add("Hyderabad");
        cities.add("Mumbai");
        cities.add("Delhi");
        cities.add("Chennai");
        cities.add("Mumbai"); // duplicate - ignored, order unchanged
        System.out.println("Cities: " + cities);
        // Output: [Hyderabad, Mumbai, Delhi, Chennai]

        // 2. Remove preserves order of remaining elements
        cities.remove("Delhi");
        System.out.println("After remove: " + cities);
        // 3. Deduplication while preserving order - practical use
        List<Integer> withDups = Arrays.asList(3,1,4,1,5,9,2,6,5,3);
        Set<Integer> unique = new LinkedHashSet<>(withDups);
        System.out.println("With dups : " + withDups);
        System.out.println("Deduplicated: " + unique);
        // Output: [3, 1, 4, 5, 9, 2, 6] - first occurrence, same order

        // 4. Compare with HashSet (same elements, different order)
        Set<Integer> hashSet   = new HashSet<>(withDups);
        Set<Integer> linkedSet = new LinkedHashSet<>(withDups);
        System.out.println("HashSet      : " + hashSet);   // random order
        System.out.println("LinkedHashSet: " + linkedSet); // insertion order

        // 5. Convert back to List (preserves order)
        List<Integer> result = new ArrayList<>(unique);
        System.out.println("Back to List: " + result);
        // 6. Size and empty check
        System.out.println("Size   : " + unique.size());
        System.out.println("isEmpty: " + unique.isEmpty());
    }
}