package org.example.Collections.Task11;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        GradeManagementSystem system = new GradeManagementSystem();

        // Sample Data
        ArrayList<Double> aliceGrades =
                new ArrayList<>(Arrays.asList(85.0, 90.0, 78.0));
        ArrayList<Double> bobGrades =
                new ArrayList<>(Arrays.asList(88.0, 92.0, 80.0));

        // Add students
        system.addStudent(1, "Alice", aliceGrades);
        system.addStudent(2, "Bob", bobGrades);

        // Update Alice's grades
        ArrayList<Double> updatedAliceGrades =
                new ArrayList<>(Arrays.asList(87.0, 91.0, 82.0));
        system.updateGrades(1, updatedAliceGrades);

        // Retrieve and print average grades
        double aliceAvg = system.getAverageGrade(1);
        double bobAvg = system.getAverageGrade(2);

        System.out.println("Average grade for Alice: " + aliceAvg);
        System.out.println("Average grade for Bob: " + bobAvg);
    }
}

