package commandos.commandos.informative;

import carpark.Carpark;
import commandos.Commando;

import java.util.Map;

public class GetAmountCarsCommando implements Commando {

	Carpark carpark;

	public GetAmountCarsCommando(Carpark carpark) {
		this.carpark = carpark;
	}

	@Override
	public void execute(Map<String, String> parameters) {
		PRINT_TO_CONSOLE_SERVICE.print(carpark.getAmountCars() + " Autos sind im Parkhaus");
	}

	@Override
	public String getDescription() {
		return "Ausgabe Anzahl der registrierten Autos";
	}

	@Override
	public String getParameterList() {
		return "-";
	}
}
