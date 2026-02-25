package org.example.Collections.Task11;

import java.util.ArrayList;
import java.util.TreeMap;

public class GradeManagementSystem {

    // TreeMap to keep students sorted by ID
    private TreeMap<Integer, Student> studentMap;

    public GradeManagementSystem() {
        studentMap = new TreeMap<>();
    }

    // Add new student
    public void addStudent(int id, String name, ArrayList<Double> grades) {
        Student student = new Student(name, grades);
        studentMap.put(id, student);
    }

    // Update grades of existing student
    public void updateGrades(int id, ArrayList<Double> newGrades) {
        Student student = studentMap.get(id);
        if (student != null) {
            student.setGrades(newGrades);
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    // Calculate average grade for a student
    public double getAverageGrade(int id) {
        Student student = studentMap.get(id);
        if (student == null) {
            System.out.println("Student with ID " + id + " not found.");
            return 0.0;
        }

        ArrayList<Double> grades = student.getGrades();
        double sum = 0.0;

        for (Double grade : grades) {
            sum += grade;
        }

        return sum / grades.size();
    }

    // Optional: Display all students (for debugging)
    public void displayAllStudents() {
        for (Integer id : studentMap.keySet()) {
            Student s = studentMap.get(id);
            System.out.println("ID: " + id + ", Name: " + s.getName() +
                    ", Grades: " + s.getGrades());
        }
    }
}

