package org.example.Collections.Task9;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        NewPostOfficeStorage storage = new NewPostOfficeStorageImpl();

        Box b1 = new Box("A", "B", 2.0, 0.1, new BigDecimal("100"), "City1", 1);
        Box b2 = new Box("C", "D", 5.0, 0.2, new BigDecimal("300"), "City2", 2);

        storage.acceptBox(b1);
        storage.acceptBox(b2);

        System.out.println(storage.getAllWeightLessThan(3)); // should show b1
    }
}

