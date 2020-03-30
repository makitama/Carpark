package main.java.commandos.commandos.Factories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DriveInCommandoParamsFactory {
	private String type;
	private String color;
	private String license_plate;
	//if car:
	private double height;
	private String manufacturer;
	//if motorcycle:
	private String mtype;

	public DriveInCommandoParamsFactory(List<String> parameters) {
		Map<String, String> parameter = splitParameters(parameters);
		type = parameter.get("TYPE");
		color = parameter.get("COLOR");
		license_plate = parameter.get("LICENSE_PLATE");
		if (type.equalsIgnoreCase("CAR")) {
			height = Double.parseDouble(parameter.get("HEIGHT"));
			manufacturer = parameter.get("MANUFACTURER");
		} else {
			mtype = parameter.get("MTYPE");
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

	public Map<String, String> splitParameters(List<String> parameters) {
		Map<String, String> params = new HashMap<>();
		for (String parameter : parameters) {
			String[] param = parameter.split("=");
			params.put(param[0], param[1]);
		}
		return params;
	}
}
