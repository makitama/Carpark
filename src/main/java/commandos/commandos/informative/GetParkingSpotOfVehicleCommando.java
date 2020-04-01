package main.java.commandos.commandos.informative;

import main.java.commandos.Commando;
import main.java.services.ParkingSpotService;
import main.java.services.PrintService;

import java.util.Map;

public class GetParkingSpotOfVehicleCommando implements Commando {

	ParkingSpotService parkingSpotService;

	public GetParkingSpotOfVehicleCommando(ParkingSpotService parkingSpotService) {
		this.parkingSpotService = parkingSpotService;
	}

	@Override
	public void execute(Map<String, String> parameters) {
		new PrintService("Das Auto mit dem Kennzeichen: " + parameters.get("LICENSE_PLATE") +
			  " parkt auf dem Parkplatz #" + parkingSpotService.getParkingSpotOfVehicle(parameters.get("License_Plate")));
	}

	@Override
	public String getDescription() {
		return "Ausgabe des Parkplatzes auf dem das AAuto parkt";
	}

	@Override
	public String getParameterList() {
		return "licenseplate";
	}
}
