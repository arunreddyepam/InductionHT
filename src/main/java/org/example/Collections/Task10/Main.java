package org.example.Collections.Task10;

public class Main {
    public static void main(String[] args) {

        Shop shop = new Shop(5);

        System.out.println("Initial state");
        shop.print();

        System.out.println("Enable cboxes 0, 2, 4");
        shop.setCashBoxState(0, CashBox.State.ENABLED);
        shop.setCashBoxState(2, CashBox.State.ENABLED);
        shop.setCashBoxState(4, CashBox.State.ENABLED);
        shop.print();

        System.out.println("Add 5 buyers");

        char ch = 'A';
        for (int i = 0; i < 5; i++) {
            shop.addBuyer(new Buyer(ch++));
        }
        shop.print();

        System.out.println("Add 8 buyers (total 13 buyers)");
        for (int i = 0; i < 8; i++) {
            shop.addBuyer(new Buyer(ch++));
        }
        shop.print();

        System.out.println("Set cbox #2 is closing");
        shop.setCashBoxState(2, CashBox.State.IS_CLOSING);
        shop.print();

        System.out.println("Do 1 tact");
        shop.tact();
        shop.print();

        System.out.println("Enable cbox #1, add 7 buyers");
        shop.setCashBoxState(1, CashBox.State.ENABLED);

        for (int i = 0; i < 7; i++) {
            shop.addBuyer(new Buyer(ch++));
        }
        shop.print();

        System.out.println("Enable cbox #3, do 1 tact");
        shop.setCashBoxState(3, CashBox.State.ENABLED);
        shop.tact();
        shop.print();

        System.out.println("Do 1 tact");
        shop.tact();
        shop.print();

        System.out.println("Do 1 tact");
        shop.tact();
        shop.print();
    }
}
