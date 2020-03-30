package main.java.vehicles;

import main.java.commandos.commandos.Factories.DriveInCommandoParamsFactory;


public enum VehicleTypes {
	MOTORCYCLE("Motorcycle"),
	CAR("Car");

	private String value;

	VehicleTypes(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public Vehicle createNewVehicle(DriveInCommandoParamsFactory driveInCommandoParamsFactory) {
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
