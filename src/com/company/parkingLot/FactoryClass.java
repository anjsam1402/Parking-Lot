package com.company.parkingLot;

public class FactoryClass {
    public Car getCarObject() {
        return new Car();
    }

    public Bike getBikeObject() {
        return new Bike();
    }

    public Truck getTruckObject() {
        return new Truck();
    }

    public Ticket getTicketObject() {
        return new Ticket();
    }

    public Slot getSlotObject() {
        return new Slot();
    }
}
