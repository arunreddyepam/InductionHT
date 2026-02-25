package org.example.Collections.Task15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class NewPostOfficeManagementImpl implements NewPostOfficeManagement {

    private List<Box> storage;

    public NewPostOfficeManagementImpl(List<Box> storage) {
        this.storage = storage;
    }

    // ---------- Get Box By Id ----------
    @Override
    public Optional<Box> getBoxById(final int id) {

        // Sort by id ASC
        Collections.sort(storage, new Comparator<Box>() {
            @Override
            public int compare(Box o1, Box o2) {
                return Integer.compare(o1.getId(), o2.getId());
            }
        });

        int index = Collections.binarySearch(storage, null, new Comparator<Box>() {
            @Override
            public int compare(Box box, Box ignored) {
                return Integer.compare(box.getId(), id);
            }
        });

        if (index >= 0) {
            return Optional.of(storage.get(index));
        }

        return Optional.empty();
    }

    // ---------- Desc Sorted By Weight ----------
    @Override
    public String getDescSortedBoxesByWeight() {

        List<Box> copy = new ArrayList<Box>(storage);

        Collections.sort(copy, new Comparator<Box>() {
            @Override
            public int compare(Box o1, Box o2) {
                return Double.compare(o2.getWeight(), o1.getWeight());
            }
        });

        StringBuilder sb = new StringBuilder();

        for (Box box : copy) {
            sb.append(box).append("\n");
        }

        return sb.toString();
    }

    // ---------- Asc Sorted By Cost ----------
    @Override
    public String getAscSortedBoxesByCost() {

        List<Box> copy = new ArrayList<Box>(storage);

        Collections.sort(copy, new Comparator<Box>() {
            @Override
            public int compare(Box o1, Box o2) {
                return o1.getCost().compareTo(o2.getCost());
            }
        });

        StringBuilder sb = new StringBuilder();

        for (Box box : copy) {
            sb.append(box).append("\n");
        }

        return sb.toString();
    }

    // ---------- Get Boxes By Recipient ----------
    @Override
    public List<Box> getBoxesByRecipient(final String recipient) {

        if (recipient == null) {
            throw new NullPointerException();
        }

        // Sort by recipient
        Collections.sort(storage, new Comparator<Box>() {
            @Override
            public int compare(Box o1, Box o2) {
                return o1.getRecipient().compareTo(o2.getRecipient());
            }
        });

        int index = Collections.binarySearch(storage, null, new Comparator<Box>() {
            @Override
            public int compare(Box box, Box ignored) {
                return box.getRecipient().compareTo(recipient);
            }
        });

        List<Box> result = new ArrayList<Box>();

        if (index < 0) {
            return result; // empty list
        }

        // Scan left
        int i = index;
        while (i >= 0 && storage.get(i).getRecipient().equals(recipient)) {
            i--;
        }

        // Scan right
        i++;
        while (i < storage.size() && storage.get(i).getRecipient().equals(recipient)) {
            result.add(storage.get(i));
            i++;
        }

        return result;
    }
}
