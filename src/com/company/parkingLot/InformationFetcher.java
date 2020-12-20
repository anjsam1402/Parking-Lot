package com.company.parkingLot;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class InformationFetcher {
    public String getRegistrationNumberFromColor(String color, Vector<Vector<Slot>> parkingLot_vector, int vector_size) {
        String FoundRegistrationNumber = null;
        for (int i = 0; i < vector_size; ++i) {
            for (int j = 0; j < vector_size; ++j) {
                Slot current = parkingLot_vector.get(i).get(j);
                if(current.getStatus() == true){
                    ArrayList<Vehicle> vehicle_list = current.getVehicleList();
                    for(int k = 0; k < vehicle_list.size(); k++){
                        if(vehicle_list.get(k).getColor() == color)
                            FoundRegistrationNumber = vehicle_list.get(i).getRegistrationNumber();
                    }
                }
            }
        }
        return FoundRegistrationNumber;
    }

    public int getSlotIdFromRegistrationNumber(String registrationNumber,Vector<Vector<Slot>> parkingLot_vector, int vector_size) {
        int FoundSlotIdNumber = 0;
        for (int i = 0; i < vector_size; ++i) {
            for (int j = 0; j < vector_size; ++j) {
                Slot current = parkingLot_vector.get(i).get(j);
                if (current.getStatus() == true) {
                    ArrayList<Vehicle> vehicle_list = current.getVehicleList();
                    for (int k = 0; k < vehicle_list.size(); k++) {
                        if (vehicle_list.get(k).getRegistrationNumber() == registrationNumber)
                            FoundSlotIdNumber = current.getSlotId();
                    }
                }
            }
        }
        return FoundSlotIdNumber;
    }

    public ArrayList<Integer> getSlotIdVectorFromColor(String color, Vector<Vector<Slot>> parkingLot_vector, int vector_size) {
         ArrayList<Integer> FoundSlotIdVector = new ArrayList<Integer>();
        for (int i = 0; i < vector_size; ++i) {
            for (int j = 0; j < vector_size; ++j) {
                Slot current = parkingLot_vector.get(i).get(j);
                if (current.getStatus() == true) {
                    ArrayList<Vehicle> vehicle_list = current.getVehicleList();
                    for (int k = 0; k < vehicle_list.size(); k++) {
                        if (vehicle_list.get(k).getColor() == color)
                            FoundSlotIdVector.add(i, current.getSlotId());
                    }
                }
            }
        }
        return FoundSlotIdVector;
    }
}
