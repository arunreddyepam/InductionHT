package org.example.Collections.Task13;

public interface HashtableOpen8to16 {

    static HashtableOpen8to16 getInstance() {
        return new HashtableOpen8to16Impl();
    }

    void insert(int key, Object value);

    Object search(int key);

    void remove(int key);

    int size();

    int[] keys();
}

