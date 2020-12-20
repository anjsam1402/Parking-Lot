package com.company.parkingLot;

public class ParkingLotController {
    public static void main(String args[]) {
        int currentSize = 5;
        ParkingLot parkingLot = new ParkingLot(currentSize);
        System.out.println(parkingLot.parkVehicle(1,"BIKE", "UP14EE5941", "BLACK"));
        System.out.println(parkingLot.parkVehicle(1, "CAR", "UP14-15", "RED"));
        System.out.println(parkingLot.parkVehicle(2,"TRUCK", "UP37EE41", "YELLOW"));
        System.out.println(parkingLot.parkVehicle(2,"BIKE", "UPE41", "ORANGE"));
    }
}
