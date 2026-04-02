package org.example.Collections.Task6;

import java.util.*;

public class TreeSetDemo {
    public static void main(String[] args) {

        // 1. Natural (ascending) order
        TreeSet<Integer> nums = new TreeSet<>();
        nums.add(50); nums.add(10); nums.add(40);
        nums.add(20); nums.add(30); nums.add(10); // dup ignored
        System.out.println("TreeSet   : " + nums);
        // Always sorted: [10, 20, 30, 40, 50]

        // 2. Navigation operations (unique to SortedSet)
        System.out.println("First     : " + nums.first());    // 10
        System.out.println("Last      : " + nums.last());     // 50
        System.out.println("Floor(25) : " + nums.floor(25)); // <= 25 -> 20
        System.out.println("Ceiling(25): "+ nums.ceiling(25));// >= 25 -> 30
        System.out.println("Lower(30) : " + nums.lower(30)); // < 30 -> 20
        System.out.println("Higher(30): " + nums.higher(30));// > 30 -> 40
        // 3. SubSet, HeadSet, TailSet views
        System.out.println("SubSet(20,40) : " + nums.subSet(20, true, 40, true));
        System.out.println("HeadSet(<30)  : " + nums.headSet(30));       // exclusive
        System.out.println("TailSet(>=30) : " + nums.tailSet(30));       // inclusive

        // 4. Descending order
        System.out.println("Descending: " + nums.descendingSet());

        // 5. Custom Comparator (reverse order)
        TreeSet<String> words = new TreeSet<>(Comparator.reverseOrder());
        words.addAll(Arrays.asList("Banana", "Apple", "Cherry", "Date"));
        System.out.println("Reverse   : " + words);

        // 6. pollFirst / pollLast (retrieve + remove)
        System.out.println("PollFirst : " + nums.pollFirst()); // removes 10
        System.out.println("PollLast  : " + nums.pollLast());  // removes 50
        System.out.println("Remaining : " + nums);
    }
}