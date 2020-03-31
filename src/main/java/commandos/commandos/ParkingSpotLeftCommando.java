package main.java.commandos.commandos;

import main.java.commandos.Commando;
import main.java.commandos.commandos.Factories.ParkingSpotCommandosParamsFactory;
import main.java.services.ParkingService;

import java.util.Map;

public class ParkingSpotLeftCommando implements Commando {

	private ParkingService parkingService;

	public ParkingSpotLeftCommando(ParkingService parkingService) {
		this.parkingService = parkingService;
	}

	@Override
	public void execute(Map<String, String> parameters) {
		ParkingSpotCommandosParamsFactory parkingSpotCommandosParamsFactory = new ParkingSpotCommandosParamsFactory(parameters);
		parkingService.leaveParkingSpot(parkingSpotCommandosParamsFactory.getLicense_plate(), parkingSpotCommandosParamsFactory.getParking_spot_id()
			  , parkingSpotCommandosParamsFactory.getFloorNr());
	}

	@Override
	public String getDescription() {
		return "Fahrzeug parkt ein";
	}

	@Override
	public String getParameterList() {
		return "id of parkingspot, floorNr, license plate";
	}
}
