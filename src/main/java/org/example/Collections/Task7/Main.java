package org.example.Collections.Task7;

import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        NewPostOffice office = new NewPostOffice();

        // Add boxes
        office.addBox("Alice", "Bob", 2.0, 0.05, 100);
        office.addBox("Charlie", "Bob", 5.0, 0.1, 200);
        office.addBox("Alice", "Diana", 1.5, 0.02, 50);

        System.out.println("All boxes in office:");
        for (Box box : office.getListBox()) {
            System.out.println(box);
        }

        // Deliver boxes to Bob
        Collection<Box> delivered = office.deliveryBoxToRecipient("Bob");
        System.out.println("\nDelivered boxes to Bob:");
        for (Box box : delivered) {
            System.out.println(box);
        }

        // Decline cost of remaining boxes by 10%
        office.declineCostOfBox(10);
        System.out.println("\nBoxes after 10% cost decline:");
        for (Box box : office.getListBox()) {
            System.out.println(box);
        }
    }
}

