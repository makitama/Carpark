package main.java.commandos.commandos.informative;

import main.java.commandos.Commando;
import main.java.services.CarparkService;
import main.java.services.PrintService;

import java.util.Map;

public class GetParkingSpotOfVehicleCommando implements Commando {

	CarparkService carparkService;

	public GetParkingSpotOfVehicleCommando(CarparkService carparkService) {
		this.carparkService = carparkService;
	}

	@Override
	public void execute(Map<String, String> parameters) {
		new PrintService("Das Auto mit dem Kennzeichen: " + parameters.get("LICENSE_PLATE") + carparkService.parkingSpotOfVehicleIfVehicleIsParked(parameters.get("LICENSE_PLATE")));
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
