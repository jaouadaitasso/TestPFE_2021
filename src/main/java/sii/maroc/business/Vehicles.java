package sii.maroc.business;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Vector;

import sii.maroc.models.Vehicle;

public class Vehicles {

	private Vehicle vehicle = new Vehicle();
	private List<String> consumPercentages = new Vector();

	public Vehicles() {
		super();
	}

	public Vehicles(String consumPercentages) {
		String[] splitedText = consumPercentages.split(",");
		for (int i = 0; i < splitedText.length; i++) {
			this.consumPercentages.add(splitedText[i]);
		}
	}

	public String move(String carName, String fuelType, String doors, String distance) {
		constructCar(carName, fuelType, doors, distance);
		DecimalFormat format = new DecimalFormat("#.00");

		if (carName.equals("CAR")) {
			if (carHasAllDoors(vehicle)) {
				return "DOORS OK, MOVING. The CAR will consume " + format.format(calculConsumption(distance, fuelType))
						+ " L";
			}
			
			if (carHasNotSecondDoor(vehicle)) {
				return "DOORS KO, BLOCKED \n"+
                        "  _\n"+
                        " | \\\n"+
                        " |_|";
			}
			
			if (carHasNotThirdDoor(vehicle)) {
				return "DOORS KO, BLOCKED \n"+
                        "  _\n"+
                        " | |\n"+
                        " /_|";
			}
		}

		if (carName.equals("TRUCK")) {
			if (truckHasAllDoors(vehicle)) {

				return "DOORS OK, MOVING. The TRUCK will consume "
						+ format.format(calculConsumption(distance, fuelType)) + " L";
			}
		}

		if (carName.equals("MOTORCYCLE")) {

			return "DOORS OK, MOVING. The MOTORCYCLE will consume "
					+ format.format(calculConsumption(distance, fuelType)) + " L";

		}

		return "";
	}

	public void constructCar(String carName, String fuelType, String doors, String distance) {
		vehicle.setName(carName);
		vehicle.setFuelType(fuelType);
		vehicle.setDistance(Integer.parseInt(distance.split(" ")[0]));

		if (doors.length() > 0) {
			String[] splitedDoors = doors.split(" ");
			for (int i = 0; i < splitedDoors.length; i++) {
				vehicle.addDoor(Integer.parseInt(splitedDoors[i]));
			}	
		}
	}

	public double calculConsumption(String dist, String fuelType) {
		double distance = Double.parseDouble(dist.split(" ")[0]);

		double doublePercentage = 0;
		for (String s : consumPercentages) {
			if (s.contains(fuelType)) {
				String stringPercentage = s.split(":")[1];
				doublePercentage = Double.parseDouble(
						stringPercentage.substring(0, stringPercentage.length() - 1));
			}
		}

		return (distance * 10) * (doublePercentage * 0.1) / 100;
	}
	
	
	public boolean carHasAllDoors(Vehicle vehicle) {
		if (vehicle.getDoors().contains(1) && vehicle.getDoors().contains(2) && vehicle.getDoors().contains(3)
				&& vehicle.getDoors().contains(4)) {
			return true;
		}
		return false;
	}
	
	
	public boolean truckHasAllDoors(Vehicle vehicle) {
		if (vehicle.getDoors().contains(1) && vehicle.getDoors().contains(2)) {
			return true;
		}
		return false;
	}
	
	
	public boolean carHasNotSecondDoor(Vehicle vehicle) {
		if (vehicle.getDoors().contains(2)) {
			return false;
		}
		return true;
	}
	
	public boolean carHasNotThirdDoor(Vehicle vehicle) {
		if (vehicle.getDoors().contains(3)) {
			return false;
		}
		return true;
	}
	

}
