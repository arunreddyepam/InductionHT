package org.example.DesignPatterns.BuilderPattern;

public class Bicycle {

    // Mandatory fields
    private final String brand;
    private final String model;

    // Optional fields
    private final boolean gears;
    private final boolean doubleStand;
    private final boolean doubleSeat;
    private final boolean carrier;

    // Private constructor
    private Bicycle(Builder builder) {
        this.brand = builder.brand;
        this.model = builder.model;
        this.gears = builder.gears;
        this.doubleStand = builder.doubleStand;
        this.doubleSeat = builder.doubleSeat;
        this.carrier = builder.carrier;
    }

    public void showSpecifications() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Gears: " + gears);
        System.out.println("Double Stand: " + doubleStand);
        System.out.println("Double Seat: " + doubleSeat);
        System.out.println("Carrier: " + carrier);
    }

    // Static Builder Class
    public static class Builder {

        // Mandatory fields
        private final String brand;
        private final String model;

        // Optional fields (default false)
        private boolean gears;
        private boolean doubleStand;
        private boolean doubleSeat;
        private boolean carrier;

        public Builder(String brand, String model) {
            this.brand = brand;
            this.model = model;
        }

        public Builder addGears() {
            this.gears = true;
            return this;
        }

        public Builder addDoubleStand() {
            this.doubleStand = true;
            return this;
        }

        public Builder addDoubleSeat() {
            this.doubleSeat = true;
            return this;
        }

        public Builder addCarrier() {
            this.carrier = true;
            return this;
        }

        public Bicycle build() {
            return new Bicycle(this);
        }
    }
}

