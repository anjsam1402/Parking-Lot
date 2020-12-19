package com.company.parkingLot;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AvailableSlotFetcherService implements SlotFetcher {
    @Override
    public Slot getSlot(int EntryGate, Vehicle vehicle, ParkingLot parkingLot) {
        Slot needed = null;
        System.out.println("Inside Strategy");
        for (int i = 0; i < parkingLot.getSize(); ++i) {
            ArrayList<Slot> current = parkingLot.getParkingLot().get(i);
            if(current == null) break;
            for (int j = 0; j < current.size(); ++j) {
                if(current == null) break;
                Slot slotCurrentCapacity = current.get(j);
                if(slotCurrentCapacity != null &&
                        slotCurrentCapacity.getCurrentCapacity() >= vehicle.getCapacity()) {
                    needed = slotCurrentCapacity;
                    break;
                }
            }
            if(needed != null) break;
        }
        if(needed == null) {
            System.out.println("No Slot is available righ now, Please come after some time.");
        }
        return needed;
    }
}
