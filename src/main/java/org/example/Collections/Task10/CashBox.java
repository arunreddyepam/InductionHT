package org.example.Collections.Task10;

import java.util.*;

public class CashBox {

    public enum State {
        ENABLED, IS_CLOSING, DISABLED
    }

    private int number;
    private State state;
    private Deque<Buyer> queue;

    public CashBox(int number) {
        this.number = number;
        this.state = State.DISABLED;
        this.queue = new ArrayDeque<>();
    }

    public int getNumber() {
        return number;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    // Returns copy of queue
    public Deque<Buyer> getQueue() {
        return new ArrayDeque<>(queue);
    }

    // Serve first buyer
    public Buyer serveBuyer() {
        if (queue.isEmpty()) {
            return null;
        }

        Buyer served = queue.removeFirst();

        // If was closing and now empty → disable
        if (state == State.IS_CLOSING && queue.isEmpty()) {
            state = State.DISABLED;
        }

        return served;
    }

    public boolean inState(State state) {
        return this.state == state;
    }

    public boolean notInState(State state) {
        return this.state != state;
    }

    public void addLast(Buyer buyer) {
        queue.addLast(buyer);
    }

    public Buyer removeLast() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.removeLast();
    }

    public int size() {
        return queue.size();
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("#").append(number);

        if (state == State.ENABLED) {
            sb.append("[+] ");
        } else if (state == State.IS_CLOSING) {
            sb.append("[|] ");
        } else {
            sb.append("[-] ");
        }

        for (Buyer b : queue) {
            sb.append(b);
        }

        return sb.toString();
    }
}
