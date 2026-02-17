package org.example.Collections;

import java.util.*;

public class CollectionsDemo {
    public static void main(String[] args) {
        // a) ArrayList
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Cherry");
        System.out.println("ArrayList: " + arrayList);

        // b) LinkedList
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Dog");
        linkedList.add("Elephant");
        linkedList.add("Frog");
        System.out.println("LinkedList: " + linkedList);

        // c) HashMap
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "One");
        hashMap.put(2, "Two");
        hashMap.put(3, "Three");
        System.out.println("HashMap: " + hashMap);

        // d) LinkedHashMap
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(10, "Ten");
        linkedHashMap.put(20, "Twenty");
        linkedHashMap.put(30, "Thirty");
        System.out.println("LinkedHashMap: " + linkedHashMap);

        // e) HashSet
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Red");
        hashSet.add("Green");
        hashSet.add("Blue");
        System.out.println("HashSet: " + hashSet);

        // f) LinkedHashSet
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Monday");
        linkedHashSet.add("Tuesday");
        linkedHashSet.add("Wednesday");
        System.out.println("LinkedHashSet: " + linkedHashSet);
    }
}