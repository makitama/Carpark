package commandos.commandos.informative;

import commandos.Commando;
import commandos.commandos.Factories.GetParkingSpotOfVehicleCommandoParamsFactory;
import services.CarparkService;

import java.io.IOException;
import java.util.Map;

public class GetParkingSpotOfVehicleCommando implements Commando {

	CarparkService carparkService;

	public GetParkingSpotOfVehicleCommando(CarparkService carparkService) {
		this.carparkService = carparkService;
	}

	@Override
	public void execute(Map<String, String> parameters) {
		GetParkingSpotOfVehicleCommandoParamsFactory paramsFactory = new GetParkingSpotOfVehicleCommandoParamsFactory(parameters);
		String output = "Das Auto mit dem Kennzeichen: " + parameters.get("LICENSE_PLATE") + carparkService.parkingSpotOfVehicleIfVehicleIsParked(parameters.get("LICENSE_PLATE"));
		if (paramsFactory.isEmpty()) {
			PRINT_TO_CONSOLE_SERVICE.print(output);
		} else {
			try {
				PRINT_TO_FILE_SERVICE.print(paramsFactory.getFile(), output);
			} catch (IOException ex) {
				PRINT_TO_CONSOLE_SERVICE.printErrorMessage(ex.getMessage());
			}
		}
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
