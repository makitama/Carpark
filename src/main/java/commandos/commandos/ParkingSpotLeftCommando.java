package commandos.commandos;

import commandos.Commando;
import commandos.commandos.Factories.ParkingSpotCommandosParamsFactory;
import services.ParkingService;

import java.util.Map;

public class ParkingSpotLeftCommando implements Commando {

	private ParkingService parkingService;

	public ParkingSpotLeftCommando(ParkingService parkingService) {
		this.parkingService = parkingService;
	}

	@Override
	public void execute(Map<String, String> parameters) {
		ParkingSpotCommandosParamsFactory parkingSpotCommandosParamsFactory = new ParkingSpotCommandosParamsFactory(parameters);
		if (parkingService.leaveParkingSpot(parkingSpotCommandosParamsFactory.getLicense_plate(),
			  parkingSpotCommandosParamsFactory.getParking_spot_id(), parkingSpotCommandosParamsFactory.getFloorNr())) {
			DATABASE_SERVICE.unparkInDatabase(parkingSpotCommandosParamsFactory);
			PRINT_TO_CONSOLE_SERVICE.printSuccessMessage("Class " + PRINT_TO_CONSOLE_SERVICE.getActualClassName());
		}
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
