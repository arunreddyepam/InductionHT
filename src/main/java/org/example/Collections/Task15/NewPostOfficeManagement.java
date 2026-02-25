package org.example.Collections.Task15;

import java.util.List;
import java.util.Optional;

public interface NewPostOfficeManagement {

    Optional<Box> getBoxById(int id);

    String getDescSortedBoxesByWeight();

    String getAscSortedBoxesByCost();

    List<Box> getBoxesByRecipient(String recipient);
}

