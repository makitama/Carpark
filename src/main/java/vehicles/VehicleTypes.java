package main.java.vehicles;

import main.java.commandos.commandos.Factories.DriveInCommandoParamsFactory;


public enum VehicleTypes {
	MOTORCYCLE("Motorcycle"),
	CAR("Car");

	private String value;
	VehicleTypes(String value) {
	}

	public Vehicle createNewVehicle(List<String> parameters){
		Vehicle vehicle;
		switch (value) {
			case "Car":
				vehicle = new Car(driveInCommandoParamsFactory);
				break;
			case "Motorcycle":
				vehicle = new Motorcycle(driveInCommandoParamsFactory);
				break;
			default:
				throw new IllegalStateException("Unexpected value: " + value);
		}
		return vehicle;
	}
}
