package commandos.commandos.informative;

import commandos.Commando;
import commandos.commandos.Factories.ListCommandoParamsFactory;
import services.ParkingService;

import java.io.IOException;
import java.util.Map;

public class GetAmountFreeParkingSpotsCommando implements Commando {

	ParkingService parkingService;

	public GetAmountFreeParkingSpotsCommando(ParkingService parkingService) {
		this.parkingService = parkingService;
	}

	@Override
	public void execute(Map<String, String> parameters) {
		ListCommandoParamsFactory paramsFactory = new ListCommandoParamsFactory(parameters);
		String output = "Aktuell sind noch " + parkingService.getAmountFreeParkingSpots()[0] + " Autoparkplätze und " +
			  parkingService.getAmountFreeParkingSpots()[1] + " Motorradparkplätze verfügbar";
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
		return "Ausgabe Anzahl der nicht belegten Parkplätze";
	}

	@Override
	public String getParameterList() {
		return "-";
	}
}
