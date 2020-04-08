package commandos.commandos.informative;

import carpark.Carpark;
import commandos.Commando;
import commandos.commandos.Factories.ListCommandoParamsFactory;
import exceptions.NoParkingSpotOfVehicleFoundException;
import services.CarparkService;
import vehicles.Car;
import vehicles.Vehicle;

import java.io.IOException;
import java.util.Map;

public class ListCarsCommando implements Commando {

	private CarparkService carparkService;
	private Carpark carpark;

	public ListCarsCommando(CarparkService carparkService, Carpark carpark) {
		this.carparkService = carparkService;
		this.carpark = carpark;
	}

	@Override
	public void execute(Map<String, String> parameters) throws NoParkingSpotOfVehicleFoundException {
/*		if (parameters.isEmpty()) {
			carparkService.listCars(PRINT_TO_CONSOLE_SERVICE);
		} else {
			try {
				carparkService.listCars(parameters.get("FILE"), PRINT_TO_FILE_SERVICE);
			} catch (IOException ex) {
				PRINT_TO_CONSOLE_SERVICE.printErrorMessage(ex.getMessage());
			}
		}*/
		ListCommandoParamsFactory paramsFactory = new ListCommandoParamsFactory(parameters);
		if (paramsFactory.isEmpty()) {
			for (Vehicle vehicle : carpark.getCars()) {
				if (vehicle instanceof Car) {
					PRINT_TO_CONSOLE_SERVICE.print(vehicle.toString() + carparkService.parkingSpotOfVehicleIfVehicleIsParked(vehicle.getLicenseplate()));
				}
			}
		} else {
			try {
				for (Vehicle vehicle : carpark.getCars()) {
					if (vehicle instanceof Car) {
						PRINT_TO_FILE_SERVICE.print(paramsFactory.getFile(),
							  vehicle.toString() + carparkService.parkingSpotOfVehicleIfVehicleIsParked(vehicle.getLicenseplate()));
					}
				}
			} catch (IOException | NoParkingSpotOfVehicleFoundException ex) {
				PRINT_TO_CONSOLE_SERVICE.printErrorMessage(ex.getMessage());
			}
		}
	}

	@Override
	public String getDescription() {
		return "Listet alle Autos im Parkhaus auf";
	}

	@Override
	public String getParameterList() {
		return "optional: file -> angabe Dateipfad";
	}
}
