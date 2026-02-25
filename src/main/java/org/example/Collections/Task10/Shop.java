package org.example.Collections.Task10;

import java.util.*;

public class Shop {

    private List<CashBox> cashBoxes;

    public Shop(int n) {
        cashBoxes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cashBoxes.add(new CashBox(i));
        }
    }

    public CashBox getCashBox(int number) {
        return cashBoxes.get(number);
    }

    public void setCashBoxState(int number, CashBox.State state) {

        CashBox box = getCashBox(number);
        CashBox.State oldState = box.getState();
        box.setState(state);

        // If enabling from disabled → rebalance
        if (oldState == CashBox.State.DISABLED &&
                state == CashBox.State.ENABLED) {
            balance();
        }
    }

    public void print() {
        for (CashBox box : cashBoxes) {
            System.out.println(box);
        }
        System.out.println("==============");
    }

    public void addBuyer(Buyer buyer) {

        CashBox target = null;

        for (CashBox box : cashBoxes) {
            if (box.inState(CashBox.State.ENABLED)) {
                if (target == null || box.size() < target.size()) {
                    target = box;
                }
            }
        }

        if (target != null) {
            target.addLast(buyer);
        }
    }

    public void tact() {

        // Serve one buyer from each non-empty queue
        for (CashBox box : cashBoxes) {
            if (box.size() > 0) {
                box.serveBuyer();
            }
        }

        balance();
    }

    private void balance() {

        int enabledCount = 0;
        int totalBuyers = 0;

        for (CashBox box : cashBoxes) {
            if (box.inState(CashBox.State.ENABLED)) {
                enabledCount++;
                totalBuyers += box.size();
            }
        }

        if (enabledCount == 0) {
            return;
        }

        int min = totalBuyers / enabledCount;
        int max = min;
        if (totalBuyers % enabledCount != 0) {
            max = min + 1;
        }

        Deque<Buyer> defectors = new ArrayDeque<>();

        // Remove extra buyers
        for (CashBox box : cashBoxes) {

            if (box.inState(CashBox.State.ENABLED)) {

                int allowed = max;
                int current = box.size();

                if (current > allowed) {
                    int removeCount = current - allowed;
                    for (int i = 0; i < removeCount; i++) {
                        defectors.addLast(box.removeLast());
                    }
                }
            }
        }

        // Add missing buyers
        for (CashBox box : cashBoxes) {

            if (box.inState(CashBox.State.ENABLED)) {

                int current = box.size();

                if (current < min) {
                    int need = min - current;
                    for (int i = 0; i < need; i++) {
                        if (!defectors.isEmpty()) {
                            box.addLast(defectors.removeFirst());
                        }
                    }
                }
            }
        }
    }
}
