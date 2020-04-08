package commandos.commandos.Factories;

import com.mysql.cj.util.StringUtils;

import java.util.Map;

public class GetParkingSpotOfVehicleCommandoParamsFactory {

	private String file;
	private String licenseplate;

	public GetParkingSpotOfVehicleCommandoParamsFactory(Map<String, String> parameters) {
		this.file = parameters.get("FILE");
		this.licenseplate = parameters.get("LICENSEPLATE");
	}

	public String getFile() {
		return file;
	}

	public String getLicenseplate() {
		return licenseplate;
	}

	//todo ist in zwei klassen enthalten!
	public boolean isEmpty() {
		if (StringUtils.isEmptyOrWhitespaceOnly(getFile())) {
			return true;
		}
		return false;
	}
}
