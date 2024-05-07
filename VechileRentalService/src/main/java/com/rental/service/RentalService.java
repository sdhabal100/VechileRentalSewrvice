package com.rental.service;
import java.util.ArrayList;
import java.util.List;

import com.rental.entity.Vehicle;
import com.rental.entity.VehicleType;

public class RentalService {
    private List<Branch> branches;

    public RentalService() {
        this.branches = new ArrayList<>();
    }

    public void addBranch(String branchName) {
        branches.add(new Branch(branchName));
    }

    public void addVehicle(String branchName, Vehicle vehicle) {
        for (Branch branch : branches) {
            if (branch.getName().equals(branchName)) {
                branch.addVehicle(vehicle);
                break;
            }
        }
    }

    public void rentVehicle(String branchName, VehicleType type, int hours) {
        for (Branch branch : branches) {
            if (branch.getName().equals(branchName)) {
                branch.rentVehicle(type, hours);
                break;
            }
        }
    }

    public void printSystemView() {
        for (Branch branch : branches) {
            System.out.println("Branch: " + branch.getName());
            branch.printBranchView();
        }
    }
}
