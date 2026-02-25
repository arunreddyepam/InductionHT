package org.example.Java8.Task8;

public class Employee {
    private String name;
    private int age;
    private String department;
    private int salary;

    public Employee(String name,int age,String department,int salary){
        this.name=name;
        this.age=age;
        this.department=department;
        this.salary=salary;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getDepartment(){
        return department;
    }
    public int getSalary(){
        return salary;
    }

    public String toString(){
        return getName()+" "+age+" "+getDepartment()+" "+salary;
    }

}
