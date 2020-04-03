package vehicles;

import commandos.commandos.Factories.DriveInDriveOutCommandoParamsFactory;

public class Car extends Vehicle {

	private String brand;
	private double height;

	public Car(String brand, double height, String color, String licenseplate) {
		setColor(color);
		setLicenseplate(licenseplate);
		this.brand = brand;
		this.height = height;
	}

	public Car(DriveInDriveOutCommandoParamsFactory driveInDriveOutCommandoParamsFactory) {
		setColor(driveInDriveOutCommandoParamsFactory.getColor());
		setLicenseplate(driveInDriveOutCommandoParamsFactory.getLicense_plate());
		this.brand = driveInDriveOutCommandoParamsFactory.getManufacturer();
		this.height = driveInDriveOutCommandoParamsFactory.getHeight();
	}

	@Override
	public String toString() {
		return "Car -> " + "brand: '" + brand + "', height: '" + height + "', " + super.toString();
	}
}
