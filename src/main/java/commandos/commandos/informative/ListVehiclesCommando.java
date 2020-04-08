package commandos.commandos.informative;

import carpark.Carpark;
import commandos.Commando;
import services.CarparkService;
import vehicles.Vehicle;

import java.io.IOException;
import java.util.Map;

public class ListVehiclesCommando implements Commando {

	private CarparkService carparkService;
	private Carpark carpark;

	public ListVehiclesCommando(CarparkService carparkService, Carpark carpark) {
		this.carparkService = carparkService;
		this.carpark = carpark;
	}

	@Override
	public void execute(Map<String, String> parameters) {
		if (parameters.isEmpty()) {
			for (Vehicle vehicle : carpark.getAllVehiclesWithoutParkingSpots()) {
				PRINT_TO_CONSOLE_SERVICE.print(vehicle.toString() + carparkService.parkingSpotOfVehicleIfVehicleIsParked(vehicle.getLicenseplate()));
			}
		} else {
			try {
				for (Vehicle vehicle : carpark.getAllVehiclesWithoutParkingSpots()) {
					PRINT_TO_FILE_SERVICE.print(parameters.get("FILE"),
						  vehicle.toString() + carparkService.parkingSpotOfVehicleIfVehicleIsParked(vehicle.getLicenseplate()));
				}
			} catch (IOException ex) {
				System.err.println(ex.getMessage());
			}
		}
	}

	@Override
	public String getDescription() {
		return "Listet alle Fahrzeuge im Parkhaus auf";
	}

	@Override
	public String getParameterList() {
		return "optional: file -> angabe Dateipfad";
	}
}
