package commandos.commandos.informative;

import carpark.Carpark;
import commandos.Commando;

import java.util.Map;

public class GetAmountVehiclesCommando implements Commando {

	Carpark carpark;

	public GetAmountVehiclesCommando(Carpark carpark) {
		this.carpark = carpark;
	}

	@Override
	public void execute(Map<String, String> parameters) {
		PRINT_TO_CONSOLE_SERVICE.print("Aktuell sind " + carpark.getAmountVehicles() + " Fahrzeuge im Parkhaus");
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
