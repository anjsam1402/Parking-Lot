package com.company.parkingLot;

public class FactoryClass {
    public Bike getBikeObject(String color, String registrationNumber) {
        return new Bike(1, color, registrationNumber);
    }

    public Car getCarObject(String color, String registrationNumber) {
        return new Car(2, color, registrationNumber);
    }

    public Truck getTruckObject(String color, String registrationNumber) {
        return new Truck(4, color, registrationNumber);
    }

    public Ticket getTicketObject() {
        return new Ticket();
    }

    public Slot getSlotObject() {
        return new Slot();
    }
}
