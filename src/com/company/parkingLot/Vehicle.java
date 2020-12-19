package com.company.parkingLot;

public interface Vehicle {
    public VehicleIdGenerator generator = VehicleIdGenerator.getVehicleIdGenerator();
    String getVehicleType();
    int getCapacity();
    String getColor();
    String getRegistrationNumber();
    int getVehicleId();
    void setCapacity(int capacity);
    void setVehicleType(String vehicleType);
    void setColor(String color);
    void setRegistrationNumber(String registrationNumber);
}
