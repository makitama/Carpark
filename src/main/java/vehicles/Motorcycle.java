package vehicles;

import commandos.commandos.Factories.DriveInDriveOutCommandoParamsFactory;

public class Motorcycle extends Vehicle {

	private final String mtype;

	public Motorcycle(String mtype, String color, String licenseplate) {
		setColor(color);
		setLicenseplate(licenseplate);
		this.mtype = mtype;
	}

	public Motorcycle(DriveInDriveOutCommandoParamsFactory driveInDriveOutCommandoParamsFactory) {
		setColor(driveInDriveOutCommandoParamsFactory.getColor());
		setLicenseplate(driveInDriveOutCommandoParamsFactory.getLicense_plate());
		this.mtype = driveInDriveOutCommandoParamsFactory.getMtype();
	}

	public String getMtype() {
		return mtype;
	}

	@Override
	public String toString() {
		return "Motorcycle -> " + "type: '" + mtype + "'" + super.toString();
	}
}
