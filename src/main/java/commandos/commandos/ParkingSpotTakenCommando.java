package commandos.commandos;

import commandos.Commando;
import commandos.commandos.Factories.ParkingSpotCommandoParamsFactory;
import services.ParkingService;

import java.util.Map;

public class ParkingSpotTakenCommando implements Commando {

	private ParkingService parkingService;

	public ParkingSpotTakenCommando(ParkingService parkingService) {
		this.parkingService = parkingService;
	}

	@Override
	public void execute(Map<String, String> parameters) {
		ParkingSpotCommandoParamsFactory parkingSpotCommandoParamsFactory = new ParkingSpotCommandoParamsFactory(parameters);
		if (parkingService.takeParkingSpot(parkingSpotCommandoParamsFactory.getLicense_plate(), parkingSpotCommandoParamsFactory.getParking_spot_id()
			  , parkingSpotCommandoParamsFactory.getFloorNr())) {
			DATABASE_SERVICE.parkInDatabase(parkingSpotCommandoParamsFactory);
			PRINT_TO_CONSOLE_SERVICE.printSuccessMessage(PRINT_TO_CONSOLE_SERVICE.getActualClassName());

		}
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
