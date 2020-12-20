package com.company.parkingLot;

import java.util.*;
public class ParkingLot {

    private SlotFetcher strategy = null;
    Vector< Vector<Slot> > parkingLot;
    private FactoryClass factoryClass = null;
    private int size = -1;

    ParkingLot(int size) {
        System.out.println("Parking Lot created of Size: " + size + " x " + size);
        this.size = size;
        factoryClass = new FactoryClass();
        strategy = new AvailableSlotFetcherService();//This seems to be the default strategy
        parkingLot = new Vector<Vector<Slot>>(this.size + 1);
        initParkingLot();
    }

    public void initParkingLot() {
        System.out.println("Initializing Parking Lot");
        for (int i = 0; i < this.size; ++i) {
            parkingLot.add(i, new Vector<Slot>(this.size + 1));
            for (int j = 0; j < this.size; ++j) {
                parkingLot.get(i).add(j, factoryClass.getSlotObject());
            }
        }
    }

    public Ticket parkVehicle(int entryGate, String vehicleType, String registrationNumber, String color) {
        Vehicle vehicle = null;
        if(vehicleType.equals("CAR")) {
            vehicle = factoryClass.getCarObject(color, registrationNumber);
        } else if(vehicleType.equals("BIKE")) {
            vehicle = factoryClass.getBikeObject(color, registrationNumber);
        } else if(vehicleType.equals("TRUCK")) {
            vehicle = factoryClass.getTruckObject(color, registrationNumber);
        } else {
            System.out.println("Current Vehicle type is not supported");
        }

        Slot allotedSlot = getFreeSlot(entryGate, vehicle);
        if(allotedSlot == null) {
            System.out.println("No slot is availble");
            return null;
        }
        allotedSlot.reserveSlot(vehicle); // Slot is alloted to the vehicle
        Ticket ticket = factoryClass.getTicketObject();
        ticket.setVehicle(vehicle);
        ticket.setSlot(allotedSlot);
        ticket.setEntryTime(java.time.LocalTime.now());
        return ticket;
    }

    public boolean changeAllocationStrategy(String strategy) {
        if(strategy.equals("nearest")) {
            this.strategy = new NearestSlotFetcherService();
            return true;
        } else if(strategy.equals("default")) {
            this.strategy = new AvailableSlotFetcherService();
            return true;
        }
        System.out.println("Current Service is applicable");
        return false;
    }

    private Slot getFreeSlot(int entryGateNumber, Vehicle vehicle) {
        return strategy.getSlot(entryGateNumber, vehicle, this);
    }

    public int getSize() {
        return this.size;
    }

    public Vector<Vector<Slot>> getParkingLot() {
        return parkingLot;
    }
}
