package org.example.Collections.Task6;

import java.util.*;

public class CollectionsDemo {
    public static void main(String[] args) {

        // a) ArrayList (Allows duplicates, maintains insertion order)
        System.out.println("=== ArrayList ===");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Apple");   // duplicate allowed
        System.out.println(arrayList);

        // b) LinkedList (Doubly linked list, allows duplicates)
        System.out.println("\n=== LinkedList ===");
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Cat");
        linkedList.add("Dog");
        linkedList.addFirst("Elephant"); // specific to LinkedList
        System.out.println(linkedList);

        // c) HashMap (No order, unique keys)
        System.out.println("\n=== HashMap ===");
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(101, "John");
        hashMap.put(102, "Mary");
        hashMap.put(101, "Alex");   // overwrites value
        System.out.println(hashMap);

        // d) LinkedHashMap (Maintains insertion order)
        System.out.println("\n=== LinkedHashMap ===");
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1, "Red");
        linkedHashMap.put(2, "Green");
        linkedHashMap.put(3, "Blue");
        System.out.println(linkedHashMap);

        // e) HashSet (No duplicates, no order)
        System.out.println("\n=== HashSet ===");
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Java");
        hashSet.add("Python");
        hashSet.add("Java");   // duplicate ignored
        System.out.println(hashSet);

        // f) LinkedHashSet (Maintains insertion order, no duplicates)
        System.out.println("\n=== LinkedHashSet ===");
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("One");
        linkedHashSet.add("Two");
        linkedHashSet.add("One");   // duplicate ignored
        System.out.println(linkedHashSet);

        // g) TreeSet (Sorted order, no duplicates)
        System.out.println("\n=== TreeSet ===");
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(50);
        treeSet.add(10);
        treeSet.add(30);
        treeSet.add(10);   // duplicate ignored
        System.out.println(treeSet);  // Sorted output

        // h) TreeMap (Sorted by key)
        System.out.println("\n=== TreeMap ===");
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(3, "C");
        treeMap.put(1, "A");
        treeMap.put(2, "B");
        System.out.println(treeMap);  // Sorted by key
    }
}

