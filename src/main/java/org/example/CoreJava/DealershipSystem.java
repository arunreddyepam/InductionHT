package org.example.CoreJava;

// Vehicle interface
interface Vehicle {
    void start();
    void stop();
    void service();
}

// Car class implementing Vehicle
class Car implements Vehicle {
    private String model;
    private int numberOfWheels;

    public Car(String model) {
        this.model = model;
        this.numberOfWheels = 4;
    }

    @Override
    public void start() {
        System.out.println(model + " car started.");
    }

    @Override
    public void stop() {
        System.out.println(model + " car stopped.");
    }

    @Override
    public void service() {
        System.out.println(model + " car is being serviced.");
    }

    public void displayInfo() {
        System.out.println("Car Model: " + model + ", Wheels: " + numberOfWheels);
    }
}

// Truck class implementing Vehicle
class Truck implements Vehicle {
    private String model;
    private int loadCapacity; // in kilograms

    public Truck(String model, int loadCapacity) {
        this.model = model;
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void start() {
        System.out.println(model + " truck started.");
    }

    @Override
    public void stop() {
        System.out.println(model + " truck stopped.");
    }

    @Override
    public void service() {
        System.out.println(model + " truck is being serviced.");
    }

    public void displayInfo() {
        System.out.println("Truck Model: " + model + ", Load Capacity: " + loadCapacity + "kg");
    }
}

// Motorcycle class implementing Vehicle
class Motorcycle implements Vehicle {
    private String model;
    private int numberOfWheels;

    public Motorcycle(String model) {
        this.model = model;
        this.numberOfWheels = 2;
    }

    @Override
    public void start() {
        System.out.println(model + " motorcycle started.");
    }

    @Override
    public void stop() {
        System.out.println(model + " motorcycle stopped.");
    }

    @Override
    public void service() {
        System.out.println(model + " motorcycle is being serviced.");
    }

    public void displayInfo() {
        System.out.println("Motorcycle Model: " + model + ", Wheels: " + numberOfWheels);
    }
}

// Main class to test the system
public class DealershipSystem {
    public static void main(String[] args) {
        Car car = new Car("Toyota Camry");
        Truck truck = new Truck("Volvo FH", 18000);
        Motorcycle motorcycle = new Motorcycle("Yamaha R15");

        car.displayInfo();
        car.start();
        car.service();
        car.stop();

        System.out.println();

        truck.displayInfo();
        truck.start();
        truck.service();
        truck.stop();

        System.out.println();

        motorcycle.displayInfo();
        motorcycle.start();
        motorcycle.service();
        motorcycle.stop();
    }
}