package org.example.Collections.Task15;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        // ---------- Step 1: Create storage ----------
        List<Box> storage = new ArrayList<Box>();

        storage.add(new Box("Alice", "John", 10, 0.2, new BigDecimal("100"), "NY", 1));
        storage.add(new Box("Bob", "Anna", 5, 0.1, new BigDecimal("50"), "LA", 2));
        storage.add(new Box("Charlie", "John", 15, 0.3, new BigDecimal("200"), "NY", 3));
        storage.add(new Box("Diana", "Mike", 8, 0.15, new BigDecimal("80"), "TX", 1));
        storage.add(new Box("Eve", "Anna", 12, 0.25, new BigDecimal("120"), "LA", 2));

        // ---------- Step 2: Create management ----------
        NewPostOfficeManagement mgmt = new NewPostOfficeManagementImpl(storage);

        // ---------- Step 3: Test getDescSortedBoxesByWeight ----------
        System.out.println("=== Desc Sorted By Weight ===");
        System.out.println(mgmt.getDescSortedBoxesByWeight());

        // ---------- Step 4: Test getAscSortedBoxesByCost ----------
        System.out.println("=== Asc Sorted By Cost ===");
        System.out.println(mgmt.getAscSortedBoxesByCost());

        // ---------- Step 5: Test getBoxesByRecipient ===
        System.out.println("=== Boxes By Recipient: John ===");
        List<Box> johnBoxes = mgmt.getBoxesByRecipient("John");
        for (Box box : johnBoxes) {
            System.out.println(box);
        }

        System.out.println("=== Boxes By Recipient: Anna ===");
        List<Box> annaBoxes = mgmt.getBoxesByRecipient("Anna");
        for (Box box : annaBoxes) {
            System.out.println(box);
        }

        System.out.println("=== Boxes By Recipient: NonExisting ===");
        List<Box> none = mgmt.getBoxesByRecipient("NonExisting");
        System.out.println(none); // should be empty

        // ---------- Step 6: Test getBoxById ----------
        System.out.println("=== Get Box By ID ===");
        Optional<Box> box1 = mgmt.getBoxById(1);
        System.out.println("ID 1: " + box1.orElse(null));

        Optional<Box> box10 = mgmt.getBoxById(10);
        System.out.println("ID 10: " + box10.orElse(null)); // should be empty
    }
}

