package org.example.ApiTesting.Task5;

public class EmployeePOJO {

    private String name;
    private String salary;
    private String age;

    public EmployeePOJO(String name, String salary, String age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSalary() {
        return salary;
    }

    public String getAge() {
        return age;
    }
}
