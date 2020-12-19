package com.company.parkingLot;

public interface SlotFetcher {
    Slot getSlot(int EntryGate, Vehicle vehicle, ParkingLot parkingLot);
}
