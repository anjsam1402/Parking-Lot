package com.company.parkingLot;

public class VehicleIdGenerator {
    private static int id = 0;
    private static VehicleIdGenerator generator = null;


    private VehicleIdGenerator() {

    }

    public static VehicleIdGenerator getVehicleIdGenerator() {
        if(generator == null) generator = new VehicleIdGenerator();
        return generator;
    }


    public int getId() {
        ++id;
        return id;
    }
}
