package com.company.parkingLot;

import java.util.*;
public class ParkingLot {

    private SlotFetcher strategy = null;
    ArrayList< ArrayList<Slot> > parkingLot;
    private FactoryClass factoryClass = null;
    private int size = -1;

    ParkingLot(int size) {
        System.out.println("Parking Lot created of Size: " + size + " x " + size);
        this.size = size;
        factoryClass = new FactoryClass();
        strategy = new AvailableSlotFetcherService();
        parkingLot = new ArrayList<>();
        initParkingLot();
    }

    public void initParkingLot() {
        System.out.println("Initializing Parking Lot");
        ArrayList<Slot> currentList = new ArrayList<>();
        for (int i = 0; i < this.size; ++i) {
            for (int j = 0; j < this.size; ++j) {
                System.out.println("i = " + i + " j = " + j);
                currentList.add(factoryClass.getSlotObject());
            }
            parkingLot.add(currentList);
            currentList.clear();
        }
    }

    public Ticket parkVehicle(int entryGate, String vehicleType, String registrationNumber, String color) {
        Vehicle vehicle = null;
        if(vehicleType.equals("CAR")) {
            vehicle = factoryClass.getCarObject();
        } else if(vehicleType.equals("BIKE")) {
            vehicle = factoryClass.getBikeObject();
        } else if(vehicleType.equals("TRUCK")) {
            vehicle = factoryClass.getTruckObject();
        } else {
            System.out.println("Current Vehicle type is not supported");
        }

        Slot allotedSlot = getFreeSlot(entryGate, vehicle);
        if(allotedSlot == null) {
            System.out.println("No slot is availble");
            return null;
        }
        allotedSlot.reserveSlot(vehicle); // Slot is alloted to the
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
        return strategy.getSlot(entryGateNumber, vehicle,this);
    }

    public int getSize() {
        return this.size;
    }

    public ArrayList< ArrayList<Slot> > getParkingLot() {
        return parkingLot;
    }
}
