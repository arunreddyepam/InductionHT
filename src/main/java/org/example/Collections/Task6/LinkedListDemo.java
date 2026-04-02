package org.example.Collections.Task6;

import java.util.*;

public class LinkedListDemo {
    public static void main(String[] args) {

        // 1. Create LinkedList (also works as Queue/Deque)
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(10);
        ll.add(20);
        ll.add(30);

        // 2. Add at head and tail (Deque operations)
        ll.addFirst(5);   // O(1) - add to front
        ll.addLast(40);  // O(1) - add to end
        ll.offerFirst(1); // same as addFirst (queue-safe)
        System.out.println("List : " + ll);

        // 3. Peek and poll (Queue operations)
        System.out.println("Peek First: " + ll.peekFirst());  // view without remove
        System.out.println("Peek Last : " + ll.peekLast());
        System.out.println("Poll First: " + ll.pollFirst()); // remove from front
        System.out.println("After poll: " + ll);

        // 4. Stack operations (Deque as Stack)
        ll.push(99);   // push to front (LIFO)
        System.out.println("After push: " + ll);
        System.out.println("Pop       : " + ll.pop()); // remove from front

        // 5. Index-based access (O(n) unlike ArrayList)
        System.out.println("Get index 1: " + ll.get(1));

        // 6. Remove specific element
        ll.remove(Integer.valueOf(20)); // remove by value
        System.out.println("After remove 20: " + ll);

        // 7. Iterate using Iterator (safe removal)
        Iterator<Integer> it = ll.iterator();
        while (it.hasNext()) {
            int val = it.next();
            if (val % 2 == 0) it.remove(); // remove evens safely
        }
        System.out.println("Odds only: " + ll);
    }
}

