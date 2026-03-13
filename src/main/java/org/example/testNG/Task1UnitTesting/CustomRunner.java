package org.example.testNG.Task1UnitTesting;

import org.testng.TestNG;
import org.testng.TestNG;

import java.util.*;

public class CustomRunner {
    public static void main(String[] args) {
        TestNG testng = new TestNG();
        List<String> suites = new ArrayList<>();
        suites.add("CalculatorTestng.xml");
        testng.setTestSuites(suites);
        testng.run();
    }
}
