package org.example.Collections.Task8;

import java.util.Optional;

public class DoublyLinkedListImpl implements DoublyLinkedList {

    private Node head;
    private Node tail;

    // Nested Node class
    private static class Node {
        Object item;
        Node prev;
        Node next;

        Node(Object item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    // Default constructor
    public DoublyLinkedListImpl() {
        head = null;
        tail = null;
    }

    @Override
    public boolean addFirst(Object element) {
        if (element == null) {
            throw new NullPointerException();
        }

        Node newNode = new Node(element, null, head);

        if (head != null) {
            head.prev = newNode;
        } else {
            // List was empty
            tail = newNode;
        }

        head = newNode;
        return true;
    }

    @Override
    public boolean addLast(Object element) {
        if (element == null) {
            throw new NullPointerException();
        }

        Node newNode = new Node(element, tail, null);

        if (tail != null) {
            tail.next = newNode;
        } else {
            // List was empty
            head = newNode;
        }

        tail = newNode;
        return true;
    }

    @Override
    public boolean delete(int index) {
        Node node = getNodeByIndex(index);

        // unlink node
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            // deleting head
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            // deleting tail
            tail = node.prev;
        }

        return true;
    }

    @Override
    public Optional<Object> remove(Object element) {
        if (element == null) {
            throw new NullPointerException();
        }

        Node current = head;

        while (current != null) {
            if (current.item.equals(element)) {

                // unlink current
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }

                return Optional.of(current.item);
            }
            current = current.next;
        }

        return Optional.empty();
    }

    @Override
    public boolean set(int index, Object element) {
        if (element == null) {
            throw new NullPointerException();
        }

        Node node = getNodeByIndex(index);
        node.item = element;
        return true;
    }

    @Override
    public int size() {
        int count = 0;
        Node current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    @Override
    public Object[] toArray() {
        int size = size();
        Object[] array = new Object[size];

        int i = 0;
        Node current = head;
        while (current != null) {
            array[i++] = current.item;
            current = current.next;
        }

        return array;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;

        while (current != null) {
            sb.append(current.item.toString());
            if (current.next != null) {
                sb.append(" ");
            }
            current = current.next;
        }

        return sb.toString();
    }

    // Helper method (allowed, NOT in Node)
    private Node getNodeByIndex(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }

        int i = 0;
        Node current = head;

        while (current != null) {
            if (i == index) {
                return current;
            }
            i++;
            current = current.next;
        }

        throw new IndexOutOfBoundsException();
    }
}

