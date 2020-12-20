package com.company.parkingLot;

import java.util.ArrayList;
import java.util.HashMap;

public class Slot {
    public static final String LOG_TAG = "SLOT";
    public static int CurrentId = 0;
    private int currentCapacity = 0;
    private int Capacity = -1;
    private int slotId = -1;
    private HashMap<Integer, Double> distanceList;
    private boolean reserved;
    private ArrayList<Vehicle> vehicleList;
    private Double INVALID = -1.0;

    Slot(int capacity, boolean reserved) {
        this.Capacity = capacity;
        ++CurrentId;
        this.slotId = CurrentId;
        this.reserved = reserved;
        this.currentCapacity = 0;
        this.distanceList = new HashMap<Integer, Double>();
        this.vehicleList = new ArrayList<Vehicle>();
    }

    Slot() {
        this(4, false);
    }


    public Double getDistanceFromGateNumber(Integer gateNumber) {
        if(distanceList.containsKey(gateNumber)) {
            return distanceList.get(gateNumber);
        } else {
            System.out.println("Invalid GateNumber");
        }
        return INVALID;
    }

    public boolean putDistanceFromGateToSlot(Integer GateNumber, Double distance) {
        distanceList.put(GateNumber, distance);
        return true;
    }




    public boolean getStatus() {
        return this.reserved;
    }

    public boolean setStatus(boolean change) {
        this.reserved = change;
        return true;
    }

    public int getCurrentCapacity() {
        return this.currentCapacity;
    }

    public int getCapacity() {
        return this.Capacity;
    }

    public int getSlotId() {
        return this.slotId;
    }

    public boolean updateCapacity(int currentCapacity) {
        if(currentCapacity + this.currentCapacity > this.Capacity) {
            return false;
        }
        this.currentCapacity += currentCapacity;
        return true;
    }

    public boolean changeStatus(boolean decision) {
        if(this.reserved == decision) {
            System.out.println("Already Same Status");
            return false;
        }
        setStatus(decision);
        return true;
    }

    //returns true If successfully reserved the slot, otherwise returns false
    public boolean reserveSlot(Vehicle vehicle) {
        if(this.currentCapacity + vehicle.getCapacity() > this.Capacity) {
            return false;
        }
        System.out.println(LOG_TAG + " Reserving the slot " + this.slotId + " for Vehicle id_: " + vehicle.getVehicleId());
        setStatus(true);
        this.vehicleList.add(vehicle);//added the vehicle to the list
        boolean isPossible = updateCapacity(vehicle.getCapacity());//updated the current capacity of the slot which is remaining
        return isPossible;
    }

    public boolean freeUpSlot(Ticket ticket) {
        if(this.reserved == false) {
            System.out.println("Slot is not reserved");
            return false;
        }

        this.reserved = false;
        updateCapacity(-ticket.getVehicle().getCapacity());
        for (Vehicle vehicle: vehicleList) {
            if(vehicle.getVehicleId() == ticket.getVehicle().getVehicleId()) {
                System.out.println("Vehicle Removed Successfully From the slot");
                vehicleList.remove(vehicle);
                break;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "currentCapacity=" + currentCapacity +
                ", Capacity=" + Capacity +
                ", slotId=" + slotId +
                ", distanceList=" + distanceList +
                ", reserved=" + reserved +
                ", INVALID=" + INVALID +
                '}';
    }
}
