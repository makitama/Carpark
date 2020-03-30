package main.java.vehicles;

import main.java.commandos.commandos.Factories.DriveInDriveOutCommandoParamsFactory;


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

	public Vehicle createNewVehicle(DriveInDriveOutCommandoParamsFactory driveInDriveOutCommandoParamsFactory) {
		Vehicle vehicle;
		switch (value) {
			case "Car":
				vehicle = new Car(driveInDriveOutCommandoParamsFactory);
				break;
			case "Motorcycle":
				vehicle = new Motorcycle(driveInDriveOutCommandoParamsFactory);
				break;
			default:
				throw new IllegalStateException("Unexpected value: " + value);
		}
		return vehicle;
	}
}
