package main.java.commandos.commandos.Factories;

import java.util.Map;

public class DriveInDriveOutCommandoParamsFactory {
	private String type;
	private String color;
	private String license_plate;
	//if car:
	private double height;
	private String manufacturer;
	//if motorcycle:
	private String mtype;

	public DriveInDriveOutCommandoParamsFactory(Map<String, String> parameters) {
		type = parameters.get("TYPE");
		color = parameters.get("COLOR");
		license_plate = parameters.get("LICENSE_PLATE");
		if (type.equalsIgnoreCase("CAR")) {
			height = Double.parseDouble(parameters.get("HEIGHT"));
			manufacturer = parameters.get("MANUFACTURER");
		} else {
			mtype = parameters.get("M_TYPE");
		}
	}

	public String getType() {
		return type;
	}

	public String getColor() {
		return color;
	}

	public String getLicense_plate() {
		return license_plate;
	}

	public double getHeight() {
		return height;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public String getMtype() {
		return mtype;
	}
}
