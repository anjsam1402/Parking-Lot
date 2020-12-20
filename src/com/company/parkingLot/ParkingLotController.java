package com.company.parkingLot;

import java.util.Iterator;
import java.util.Set;

public class ParkingLotController {
    public static void main(String args[]) {
        int currentSize = 5;
        ParkingLot parkingLot = new ParkingLot(currentSize);
        System.out.println(parkingLot.parkVehicle(1,"BIKE", "UP14EE5941", "BLACK"));
        System.out.println(parkingLot.parkVehicle(1, "CAR", "UP14-15", "RED"));
        System.out.println(parkingLot.parkVehicle(2,"TRUCK", "UP37EE41", "YELLOW"));
        System.out.println(parkingLot.parkVehicle(2,"BIKE", "UPE41", "ORANGE"));

        System.out.println(parkingLot.parkVehicle(1,"BIKE", "UP14EE1231", "BLACK"));
        System.out.println(parkingLot.parkVehicle(1, "CAR", "UP14-1675", "BLACK"));
        System.out.println(parkingLot.parkVehicle(2,"TRUCK", "UP37EE3341", "YELLOW"));
        System.out.println(parkingLot.parkVehicle(2,"BIKE", "UPE67841", "ORANGE"));

        // run the functionalities for information fetch
        System.out.println(parkingLot.getSlotIdVectorFromColor("BLACK"));
        parkingLot.getRegistrationNumberGivenColor("BLACK");
        parkingLot.getSlotIdGivenRegistrationNumber("UPE41");
    }
}
