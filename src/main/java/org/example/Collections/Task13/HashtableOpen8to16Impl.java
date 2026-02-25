package org.example.Collections.Task13;

public class HashtableOpen8to16Impl implements HashtableOpen8to16 {

    private static final int INITIAL_CAPACITY = 8;
    private static final int MAX_CAPACITY = 16;

    private int capacity;
    private int size;

    private int[] keys;
    private Object[] values;

    // Special marker for deleted slot
    private static final int DELETED = Integer.MIN_VALUE;

    public HashtableOpen8to16Impl() {
        this.capacity = INITIAL_CAPACITY;
        this.size = 0;
        this.keys = new int[capacity];
        this.values = new Object[capacity];

        // initialize keys with empty marker
        for (int i = 0; i < capacity; i++) {
            keys[i] = DELETED;
        }
    }

    @Override
    public void insert(int key, Object value) {
        if (size == capacity) {
            if (capacity == MAX_CAPACITY) {
                throw new IllegalStateException("Maximum capacity reached");
            }
            resize(capacity * 2);
        }

        int index = findSlotForInsert(key);

        // new key
        if (values[index] == null) {
            size++;
        }

        keys[index] = key;
        values[index] = value;
    }

    @Override
    public Object search(int key) {
        int index = findSlotForSearch(key);
        if (index == -1) {
            return null;
        }
        return values[index];
    }

    @Override
    public void remove(int key) {
        int index = findSlotForSearch(key);
        if (index == -1) {
            return;
        }

        // mark as deleted
        keys[index] = DELETED;
        values[index] = null;
        size--;

        // shrink if needed
        if (size != 0 && capacity > 2 && size * 4 <= capacity) {
            resize(capacity / 2);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int[] keys() {
        int[] result = new int[size];
        int pos = 0;

        for (int i = 0; i < capacity; i++) {
            if (values[i] != null) {
                result[pos++] = keys[i];
            }
        }

        return result;
    }

    // ----------------- Internal Helpers -----------------

    private int hash(int key) {
        int h = key % capacity;
        if (h < 0) {
            h += capacity;
        }
        return h;
    }

    // For insert (linear probing)
    private int findSlotForInsert(int key) {
        int index = hash(key);

        while (true) {
            if (values[index] == null) {
                return index;
            }
            if (keys[index] == key) {
                return index;
            }
            index = (index + 1) % capacity;
        }
    }

    // For search/remove
    private int findSlotForSearch(int key) {
        int index = hash(key);
        int start = index;

        while (values[index] != null || keys[index] == DELETED) {
            if (values[index] != null && keys[index] == key) {
                return index;
            }
            index = (index + 1) % capacity;
            if (index == start) {
                break;
            }
        }
        return -1;
    }

    private void resize(int newCapacity) {
        if (newCapacity > MAX_CAPACITY) {
            newCapacity = MAX_CAPACITY;
        }
        if (newCapacity < 2) {
            newCapacity = 2;
        }

        int[] oldKeys = keys;
        Object[] oldValues = values;
        int oldCapacity = capacity;

        capacity = newCapacity;
        keys = new int[capacity];
        values = new Object[capacity];

        for (int i = 0; i < capacity; i++) {
            keys[i] = DELETED;
        }

        size = 0;

        // rehash
        for (int i = 0; i < oldCapacity; i++) {
            if (oldValues[i] != null) {
                insert(oldKeys[i], oldValues[i]);
            }
        }
    }
}

