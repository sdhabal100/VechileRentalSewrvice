package com.rental;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.rental.entity.Bike;
import com.rental.entity.Car;
import com.rental.entity.Vehicle;
import com.rental.entity.VehicleType;

	public class VehicleRentalTest {

	    @Test
	    public void testAddVehicleToBranch() {
	        Branch branch = new Branch("Branch A");
	        Car car = new Car("Car1");
	        Bike bike = new Bike("Bike1");

	        branch.addVehicle(car);
	        branch.addVehicle(bike);

	        assertEquals(2, branch.getVehicles().size());
	    }

	    @Test
	    public void testRentVehicleFromBranch() {
	        Branch branch = new Branch("Branch A");
	        Car car = new Car("Car1");
	        branch.addVehicle(car);

	        branch.rentVehicle(VehicleType.CAR, 2);

	        assertTrue(branch.getVehicles().isEmpty());
	    }

	    @Test
	    public void testRentUnavailableVehicle() {
	        Branch branch = new Branch("Branch A");
	        Bike bike = new Bike("Bike1");
	        branch.addVehicle(bike);

	        branch.rentVehicle(VehicleType.CAR, 2);

	        assertEquals(1, branch.getVehicles().size());
	    }
	}

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

	    public List<Vehicle> getVehicles() {
	        return vehicles;
	    }

	    public void addVehicle(Vehicle vehicle) {
	        vehicles.add(vehicle);
	    }

	    public void rentVehicle(VehicleType type, int hours) {
	        for (int i = 0; i < vehicles.size(); i++) {
	            if (vehicles.get(i).getType() == type) {
	                vehicles.remove(i);
	                return;
	            }
	        }
	    }
	}