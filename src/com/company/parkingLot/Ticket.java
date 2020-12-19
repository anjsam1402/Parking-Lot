package com.company.parkingLot;

import java.time.LocalTime;

public class Ticket {
    public static int currentTicket = 0;
    private int TicketId = 0;
    private Slot slotId = null;
    private Vehicle vehicle = null;
    private LocalTime entryTime = null;

    @Override
    public String toString() {
        return "Ticket{" +
                "TicketId=" + TicketId +
                ", slotId=" + slotId +
                ", vehicle=" + vehicle +
                ", entryTime=" + entryTime +
                '}';
    }

    Ticket() {
        ++currentTicket;
        this.TicketId = currentTicket;
        this.entryTime = java.time.LocalTime.now();
    }

    Ticket(Vehicle vehicle, LocalTime entryTime, Slot slotId) {
        ++currentTicket;
        this.TicketId = currentTicket;
        this.entryTime = entryTime;
        this.slotId = slotId;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public int getTicketId() {
        return TicketId;
    }

    public static void setCurrentTicket(int currentTicket) {
        Ticket.currentTicket = currentTicket;
    }

    public void setSlot(Slot slotId) {
        this.slotId = slotId;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setEntryTime(LocalTime entryTime) {
        this.entryTime = entryTime;
    }

    public static int getCurrentTicket() {
        return currentTicket;
    }

    public Slot getSlotId() {
        return slotId;
    }

    public LocalTime getEntryTime() {
        return entryTime;
    }
}
