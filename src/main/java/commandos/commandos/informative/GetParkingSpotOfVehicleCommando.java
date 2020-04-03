package commandos.commandos.informative;

import commandos.Commando;
import services.CarparkService;
import services.PrintService;

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
