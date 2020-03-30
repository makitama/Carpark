package main.java.vehicles;

import main.java.commandos.commandos.Factories.DriveInCommandoParamsFactory;

public class Car extends Vehicle {

	private String brand;
	private double height;

	public Car(String brand, double height, String color, String licenseplate) {
		setColor(color);
		setLicenseplate(licenseplate);
		this.brand = brand;
		this.height = height;
	}

	public Car(DriveInCommandoParamsFactory driveInCommandoParamsFactory) {
		setColor(driveInCommandoParamsFactory.getColor());
		setLicenseplate(driveInCommandoParamsFactory.getLicense_plate());
		this.brand = driveInCommandoParamsFactory.getManufacturer();
		this.height = driveInCommandoParamsFactory.getHeight();
	}

	@Override
	public String toString() {
		return "Car -> " + "brand: '" + brand + "', height: '" + height + "', " + super.toString();
	}
}
