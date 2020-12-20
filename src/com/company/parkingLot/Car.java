package com.company.parkingLot;

public class Car implements Vehicle {
    int vehicleId = -1;
    String vehicleType = null;
    int capacity = -1;
    String color = null;
    String registrationNumber = null;

    @Override
    public String toString() {
        return "Car{" +
                "vehicleId=" + vehicleId +
                ", vehicleType='" + vehicleType + '\'' +
                ", capacity=" + capacity +
                ", color='" + color + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                '}';
    }

    Car() {
        this.capacity = 2;
        this.vehicleId = generator.getId();
        this.vehicleType = "CAR";
    }

    Car(int capacity, String color, String registrationNumber) {
        this.capacity = capacity;
        this.color = color;
        this.registrationNumber = registrationNumber;
        this.vehicleId = generator.getId();;
        this.vehicleType = "CAR";
    }


    @Override
    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
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
