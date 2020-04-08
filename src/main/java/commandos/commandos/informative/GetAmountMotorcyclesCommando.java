package commandos.commandos.informative;

import carpark.Carpark;
import commandos.Commando;
import commandos.commandos.Factories.ListCommandoParamsFactory;

import java.io.IOException;
import java.util.Map;

public class GetAmountMotorcyclesCommando implements Commando {

	Carpark carpark;

	public GetAmountMotorcyclesCommando(Carpark carpark) {
		this.carpark = carpark;
	}

	@Override
	public void execute(Map<String, String> parameters) {
		ListCommandoParamsFactory paramsFactory = new ListCommandoParamsFactory(parameters);
		String output = carpark.getAmountMotorcycles() + " Motorräder im Parkhaus";
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
		return "Ausgabe der registrierten Motorräder";
	}

	@Override
	public String getParameterList() {
		return "-";
	}
}
