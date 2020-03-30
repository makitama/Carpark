package main.java.vehicles;

import main.java.commandos.commandos.Factories.DriveInCommandoParamsFactory;

public class Motorcycle extends Vehicle {

	private final String mtype;

	public Motorcycle(String mtype, String color, String licenseplate) {
		setColor(color);
		setLicenseplate(licenseplate);
		this.mtype = mtype;
	}

	public Motorcycle(DriveInCommandoParamsFactory driveInCommandoParamsFactory) {
		setColor(driveInCommandoParamsFactory.getColor());
		setLicenseplate(driveInCommandoParamsFactory.getLicense_plate());
		this.mtype = driveInCommandoParamsFactory.getMtype();
	}

	@Override
	public String toString() {
		return "Motorcycle -> " + "type: '" + mtype + "'";
	}
}
