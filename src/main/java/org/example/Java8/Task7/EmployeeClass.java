package org.example.Java8.Task7;

public class EmployeeClass {
    String name;
    String account;
    double salary;

    // Parameterized Constructor
    public EmployeeClass(String name, String account, double salary) {
        this.name = name;
        this.account = account;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", salary=" + salary +
                '}';
    }
}

