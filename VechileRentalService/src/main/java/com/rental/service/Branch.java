package com.rental.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rental.entity.Vehicle;
import com.rental.entity.VehicleType;

class Branch {
    private String name;
    private List<Vehicle> vehicles;

    public Branch(String name) {
        this.name = name;
        this.vehicles = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void rentVehicle(VehicleType type, int hours) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getType() == type) {
                System.out.println("Vehicle " + vehicle.getName() + " rented for " + hours + " hours.");
                vehicles.remove(vehicle);
                return;
            }
        }
        System.out.println("No available vehicles of type " + type + " in branch " + name + ".");
    }

    public void printBranchView() {
        Map<VehicleType, Integer> vehicleCounts = new HashMap<>();
        for (Vehicle vehicle : vehicles) {
            vehicleCounts.put(vehicle.getType(), vehicleCounts.getOrDefault(vehicle.getType(), 0) + 1);
        }
        for (Map.Entry<VehicleType, Integer> entry : vehicleCounts.entrySet()) {
            System.out.println("Type: " + entry.getKey() + ", Available: " + entry.getValue());
        }
    }
}


