package com.company.parkingLot;

import java.util.Vector;

public class AvailableSlotFetcherService implements SlotFetcher {
    public static final String LOG_TAG = "AvailableSlotFetcherService";
    @Override
    public Slot getSlot(int EntryGate, Vehicle vehicle, ParkingLot parkingLot) {
        Slot needed = null;
        System.out.println(LOG_TAG + " getSlot()");
        Vector<Vector<Slot>> board = parkingLot.getParkingLot();
        for (int i = 0; i < board.size(); ++i) {
            for (int j = 0; j < board.get(i).size(); ++j) {
                if(board.get(i).get(j).getCurrentCapacity() + vehicle.getCapacity() <= board.get(i).get(j).getCapacity()) {
                    needed = board.get(i).get(j);
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
