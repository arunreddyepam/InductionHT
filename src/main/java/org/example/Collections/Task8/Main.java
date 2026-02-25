package org.example.Collections.Task8;

public class Main {
    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedListImpl();

        // Test addFirst and addLast
        list.addFirst("B");
        list.addFirst("A");
        list.addLast("C");
        list.addLast("D");

        System.out.println("List should be: A B C D");
        System.out.println("Actual list:   " + list.toString());

        // Test size
        System.out.println("Size should be 4");
        System.out.println("Actual size:   " + list.size());

        // Test set
        list.set(1, "BB"); // replace B with BB
        System.out.println("After set(1, BB): A BB C D");
        System.out.println("Actual list:       " + list.toString());

        // Test delete by index
        list.delete(2); // delete C
        System.out.println("After delete(2): A BB D");
        System.out.println("Actual list:     " + list.toString());

        // Test remove by element
        System.out.println("Remove BB:");
        System.out.println("Removed: " + list.remove("BB"));
        System.out.println("List should be: A D");
        System.out.println("Actual list:   " + list.toString());

        // Test toArray
        Object[] arr = list.toArray();
        System.out.println("Array contents:");
        for (Object o : arr) {
            System.out.println(o);
        }

        // Edge case tests
        try {
            list.delete(10);
        } catch (Exception e) {
            System.out.println("Correctly caught exception for delete(10): " + e);
        }

        try {
            list.addFirst(null);
        } catch (Exception e) {
            System.out.println("Correctly caught exception for addFirst(null): " + e);
        }

        try {
            list.set(0, null);
        } catch (Exception e) {
            System.out.println("Correctly caught exception for set(0, null): " + e);
        }
    }
}

