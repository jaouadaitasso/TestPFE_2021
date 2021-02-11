package sii.maroc.models;

import java.util.List;
import java.util.Vector;

public class Vehicle {

	private String name;
	private String fuelType;
	private List<Integer> doors;
	private double distance;

	public Vehicle() {
		doors = new Vector();
	}

	public Vehicle(String name, String fuelType, List<Integer> doors, double distance) {
		super();
		this.name = name;
		this.fuelType = fuelType;
		this.doors = doors;
		this.distance = distance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public List<Integer> getDoors() {
		return doors;
	}

	public void setDoors(List<Integer> doors) {
		this.doors = doors;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	public void addDoor(Integer door) {
		doors.add(door);
	}

}
