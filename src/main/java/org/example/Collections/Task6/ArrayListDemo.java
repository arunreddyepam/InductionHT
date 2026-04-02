package org.example.Collections.Task6;

import java.util.*;

public class ArrayListDemo {
    public static void main(String[] args) {

        // 1. Create and add elements
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Apple");   // duplicates allowed
        fruits.add(1, "Mango"); // insert at index

        // 2. Access elements
        System.out.println("List   : " + fruits);
        System.out.println("Index 0: " + fruits.get(0));
        System.out.println("Size   : " + fruits.size());

        // 3. Update and remove
        fruits.set(2, "Grapes");      // update index 2
        fruits.remove("Banana");       // remove by value
        fruits.remove(0);              // remove by index

        // 4. Search
        System.out.println("Contains Cherry: " + fruits.contains("Cherry"));
        System.out.println("Index of Apple : " + fruits.indexOf("Apple"));

        // 5. Sort
        Collections.sort(fruits);
        System.out.println("Sorted : " + fruits);

        // 6. Iterate with for-each
        for (String f : fruits) {
            System.out.println("  -> " + f);
        }

        // 7. SubList and clear
        List<String> sub = fruits.subList(0, 2);
        System.out.println("SubList: " + sub);
        fruits.clear();
        System.out.println("Empty  : " + fruits.isEmpty());
    }
}
