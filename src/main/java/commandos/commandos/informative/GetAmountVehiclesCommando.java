package commandos.commandos.informative;

import carpark.Carpark;
import commandos.Commando;
import commandos.commandos.Factories.ListCommandoParamsFactory;

import java.io.IOException;
import java.util.Map;

public class GetAmountVehiclesCommando implements Commando {

	Carpark carpark;

	public GetAmountVehiclesCommando(Carpark carpark) {
		this.carpark = carpark;
	}

	@Override
	public void execute(Map<String, String> parameters) {
		ListCommandoParamsFactory paramsFactory = new ListCommandoParamsFactory(parameters);
		String output = "Aktuell sind " + carpark.getAmountVehicles() + " Fahrzeuge im Parkhaus";
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
		return "Ausgabe Anzahl der registrierten Fahrzeuge";
	}

	@Override
	public String getParameterList() {
		return "-";
	}
}
