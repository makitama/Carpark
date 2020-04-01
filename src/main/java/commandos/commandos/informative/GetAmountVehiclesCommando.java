package main.java.commandos.commandos.informative;

import main.java.Carpark;
import main.java.commandos.Commando;
import main.java.services.PrintService;

import java.util.Map;

public class GetAmountVehiclesCommando implements Commando {

	Carpark carpark;

	public GetAmountVehiclesCommando(Carpark carpark) {
		this.carpark = carpark;
	}

	@Override
	public void execute(Map<String, String> parameters) {
		new PrintService("Aktuell sind " + carpark.getAmountVehicles() + " Fahrzeuge im Parkhaus");
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
