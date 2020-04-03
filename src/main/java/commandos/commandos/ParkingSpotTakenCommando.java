package commandos.commandos;

import commandos.Commando;
import commandos.commandos.Factories.ParkingSpotCommandosParamsFactory;
import services.ParkingService;

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
	}

	@Override
	public String getDescription() {
		return "Besetzt einen Parkplatz";
	}

	@Override
	public String getParameterList() {
		return "id of parkingspot, floorNr, license plate";
	}
}
