package main.java.commandos.commandos;

import main.java.commandos.Commando;
import main.java.commandos.commandos.Factories.ParkingSpotCommandosParamsFactory;
import main.java.services.ParkingService;

import java.util.Map;

public class ParkingSpotTakenCommando implements Commando {

	private ParkingService parkingService;

	public ParkingSpotTakenCommando(ParkingService parkingService) {
		this.parkingService = parkingService;
	}

	@Override
	public void execute(Map<String, String> parameters) {
		ParkingSpotCommandosParamsFactory parkingSpotCommandosParamsFactory = new ParkingSpotCommandosParamsFactory(parameters);
		parkingService.takeParkingSpot(parkingSpotCommandosParamsFactory.getLicense_plate(), parkingSpotCommandosParamsFactory.getParking_spot_id()
			  , parkingSpotCommandosParamsFactory.getFloorNr());
		// fahrzeug muss parken => aus unparked entfernen und in parked setzen
		// parkplatz auf belegt setzen
		// ausgabe
	}

	@Override
	public String getDescription() {
		return "Besetzt einen Parkplatz";
	}

	@Override
	public String getParameterList() {
		return null;
	}
}
