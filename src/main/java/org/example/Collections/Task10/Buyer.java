package org.example.Collections.Task10;

public class Buyer {

    private char name;

    public Buyer(char name) {
        this.name = name;
    }

    public char getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.valueOf(name);
    }
}
