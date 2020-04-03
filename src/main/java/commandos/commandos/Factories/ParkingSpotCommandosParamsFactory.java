package commandos.commandos.Factories;

import java.util.Map;

public class ParkingSpotCommandosParamsFactory {

	private String license_plate;
	private int parking_spot_id;
	private int floorNr;

	public ParkingSpotCommandosParamsFactory(Map<String, String> parameters) {
		this.license_plate = parameters.get("LICENSE_PLATE");
		this.parking_spot_id = Integer.parseInt(parameters.get("PARKING_SPOT_ID"));
		this.floorNr = Integer.parseInt(parameters.get("FLOOR_NUMBER"));
	}

	public String getLicense_plate() {
		return license_plate;
	}

	public int getParking_spot_id() {
		return parking_spot_id;
	}

	public int getFloorNr() {
		return floorNr;
	}
}
