package org.example.Collections.Task9;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class NewPostOfficeStorageImpl implements NewPostOfficeStorage {

    // Aggregation (NOT inheritance)
    private final List<Box> storage;

    public NewPostOfficeStorageImpl() {
        this.storage = new ArrayList<>();
    }

    @Override
    public boolean acceptBox(Box box) {
        if (box == null) {
            throw new NullPointerException();
        }
        return storage.add(box);
    }

    @Override
    public boolean acceptAllBoxes(Collection<Box> boxes) {
        if (boxes == null) {
            throw new NullPointerException();
        }

        // First validate: no nulls
        for (Box box : boxes) {
            if (box == null) {
                throw new NullPointerException();
            }
        }

        // Add all or nothing
        try {
            for (Box box : boxes) {
                storage.add(box);
            }
            return true;
        } catch (RuntimeException e) {
            // rollback
            for (Box box : boxes) {
                removeSingleOccurrence(box);
            }
            throw e;
        }
    }

    @Override
    public boolean carryOutBoxes(Collection<Box> boxes) {
        if (boxes == null) {
            throw new NullPointerException();
        }

        boolean removedAny = false;

        for (Box box : boxes) {
            if (box == null) {
                throw new NullPointerException();
            }
            boolean removed = removeSingleOccurrence(box);
            if (removed) {
                removedAny = true;
            }
        }

        return removedAny;
    }

    @Override
    public List<Box> carryOutBoxes(Predicate<Box> predicate) {
        if (predicate == null) {
            throw new NullPointerException();
        }

        List<Box> removed = new ArrayList<>();
        Iterator<Box> it = storage.iterator();

        while (it.hasNext()) {
            Box box = it.next();
            if (predicate.test(box)) {
                removed.add(box);
                it.remove();
            }
        }

        return removed;
    }

    @Override
    public List<Box> getAllWeightLessThan(double weight) {
        List<Box> result = new ArrayList<>();

        for (Box box : storage) {
            if (box.getWeight() < weight) {
                result.add(box);
            }
        }

        return result;
    }

    @Override
    public List<Box> getAllCostGreaterThan(BigDecimal cost) {
        if (cost == null) {
            throw new NullPointerException();
        }

        List<Box> result = new ArrayList<>();

        for (Box box : storage) {
            if (box.getCost().compareTo(cost) > 0) {
                result.add(box);
            }
        }

        return result;
    }

    @Override
    public List<Box> getAllVolumeGreaterOrEqual(double volume) {
        List<Box> result = new ArrayList<>();

        for (Box box : storage) {
            if (box.getVolume() >= volume) {
                result.add(box);
            }
        }

        return result;
    }

    @Override
    public List<Box> searchBoxes(Predicate<Box> predicate) {
        if (predicate == null) {
            throw new NullPointerException();
        }

        List<Box> result = new ArrayList<>();

        for (Box box : storage) {
            if (predicate.test(box)) {
                result.add(box);
            }
        }

        return result;
    }

    @Override
    public void updateOfficeNumber(Predicate<Box> predicate, int newOfficeNumber) {
        if (predicate == null) {
            throw new NullPointerException();
        }

        for (Box box : storage) {
            if (predicate.test(box)) {
                box.setOffice(newOfficeNumber);
            }
        }
    }

    // ---------- Helper (NO forbidden methods used) ----------
    private boolean removeSingleOccurrence(Box target) {
        Iterator<Box> it = storage.iterator();

        while (it.hasNext()) {
            Box current = it.next();
            if (current == target) { // reference equality (no identity field!)
                it.remove();
                return true;
            }
        }
        return false;
    }
}

