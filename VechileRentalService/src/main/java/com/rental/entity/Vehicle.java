package com.rental.entity;

public abstract class Vehicle {
	  private String name;
	    private VehicleType type;

	    public Vehicle(String name, VehicleType type) {
	        this.name = name;
	        this.type = type;
	    }

	    public String getName() {
	        return name;
	    }

	    public VehicleType getType() {
	        return type;
	    }
	}



