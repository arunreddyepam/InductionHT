package org.example.Java8.Task7;

@FunctionalInterface
interface EmployeeFactory {
    EmployeeClass create(String name, String account, double salary);
}
