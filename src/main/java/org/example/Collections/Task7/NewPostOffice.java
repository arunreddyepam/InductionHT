package org.example.Collections.Task7;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class NewPostOffice {

    private Collection<Box> boxes;

    // Cost constants (for calculation)
    private static final BigDecimal COST_PER_KG = new BigDecimal("10.0");     // arbitrary example
    private static final BigDecimal COST_PER_M3 = new BigDecimal("200.0");    // arbitrary example
    private static final BigDecimal VALUE_COEFFICIENT = new BigDecimal("0.05"); // arbitrary example

    // Constructor
    public NewPostOffice() {
        boxes = new ArrayList<>();
    }

    // Return all parcels
    public Collection<Box> getListBox() {
        return boxes;
    }

    // Calculate cost of a box
    public static BigDecimal calculateCostOfBox(double weight, double volume, int value) {
        BigDecimal w = BigDecimal.valueOf(weight).multiply(COST_PER_KG);
        BigDecimal v = BigDecimal.valueOf(volume).multiply(COST_PER_M3);
        BigDecimal val = BigDecimal.valueOf(value).multiply(VALUE_COEFFICIENT);
        return w.add(v).add(val).setScale(2, RoundingMode.HALF_UP);
    }

    // Add box
    public boolean addBox(String sender, String recipient, double weight, double volume, int value) {
        try {
            Box box = new Box(sender, recipient, weight, volume, value);
            return boxes.add(box);
        } catch (IllegalArgumentException e) {
            System.out.println("Failed to add box: " + e.getMessage());
            return false;
        }
    }

    // Remove all boxes for a recipient
    public Collection<Box> deliveryBoxToRecipient(String recipient) {
        Collection<Box> delivered = new ArrayList<>();
        Iterator<Box> iterator = boxes.iterator();

        while (iterator.hasNext()) {
            Box box = iterator.next();
            if (box.getRecipient().equals(recipient)) {
                delivered.add(box);
                iterator.remove();  // remove from office
            }
        }
        return delivered;
    }

    // Decline cost of all boxes by a percent
    public void declineCostOfBox(double percent) {
        if (percent < 0) {
            throw new IllegalArgumentException("Percent must be non-negative");
        }

        Iterator<Box> iterator = boxes.iterator();
        while (iterator.hasNext()) {
            Box box = iterator.next();
            BigDecimal originalCost = box.getShippingCost();
            BigDecimal discount = originalCost.multiply(BigDecimal.valueOf(percent / 100.0));
            BigDecimal newCost = originalCost.subtract(discount).setScale(2, RoundingMode.HALF_UP);
            box.setShippingCost(newCost);
        }
    }
}
