package com.company.parkingLot;

public class Truck implements Vehicle {
    int vehicleId = -1;
    String vehicleType = null;
    int capacity = -1;
    String color = null;
    String registrationNumber = null;


    Truck() {
        this.vehicleId = generator.getId();
    }

    Truck(int capacity, String color, String registrationNumber) {
        this.capacity = capacity;
        this.color = color;
        this.registrationNumber = registrationNumber;
        this.vehicleId = generator.getId();
        this.vehicleType = "TRUCK";
    }

    @Override
    public String toString() {
        return "Truck{" +
                "vehicleId=" + vehicleId +
                ", vehicleType='" + vehicleType + '\'' +
                ", capacity=" + capacity +
                ", color='" + color + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                '}';
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }


    @Override
    public String getVehicleType() {
        return this.vehicleType;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public String getRegistrationNumber() {
        return this.registrationNumber;
    }

    @Override
    public int getVehicleId() {
        return this.vehicleId;
    }

}
