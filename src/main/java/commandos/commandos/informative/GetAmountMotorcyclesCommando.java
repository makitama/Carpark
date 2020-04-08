package commandos.commandos.informative;

import carpark.Carpark;
import commandos.Commando;

import java.util.Map;

public class GetAmountMotorcyclesCommando implements Commando {

	Carpark carpark;

	public GetAmountMotorcyclesCommando(Carpark carpark) {
		this.carpark = carpark;
	}

	@Override
	public void execute(Map<String, String> parameters) {
		PRINT_TO_CONSOLE_SERVICE.print(carpark.getAmountMotorcycles() + " Motorräder im Parkhaus");
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
