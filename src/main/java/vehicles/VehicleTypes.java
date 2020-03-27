package main.java.vehicles;

import java.security.Policy;
import java.util.List;

public enum VehicleTypes {
	MOTORCYCLE("Motorcycle"),
	CAR("Car");

	private String value;
	VehicleTypes(String value) {
	}

	public Vehicle createNewVehicle(List<String> parameters){
		Vehicle vehicle;
		switch(value){
			case "Car" :
				vehicle = new Car(parameters);
				break;
			case "Motorcycle" :
				vehicle = new Motorcycle(parameters);
				break;
			default:
				throw new IllegalStateException("Unexpected value: " + value);
		}
		return vehicle;
	}
}
