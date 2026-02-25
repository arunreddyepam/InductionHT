package org.example.DesignPatterns.BuilderPattern;

public class Main {

    public static void main(String[] args) {

        Bicycle bicycle1 = new Bicycle.Builder("Hero", "speed")
                .addGears()
                .addCarrier()
                .build();

        Bicycle bicycle2 = new Bicycle.Builder("Atlas", "herculean")
                .addDoubleSeat()
                .addDoubleStand()
                .build();

        bicycle1.showSpecifications();
        System.out.println("-------------------");
        bicycle2.showSpecifications();
    }
}

