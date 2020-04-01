package main.java.commandos.commandos.informative;

import main.java.Carpark;
import main.java.commandos.Commando;
import main.java.services.PrintService;

import java.util.Map;

public class GetAmountCarsCommando implements Commando {

	Carpark carpark;

	public GetAmountCarsCommando(Carpark carpark) {
		this.carpark = carpark;
	}

	@Override
	public void execute(Map<String, String> parameters) {
		new PrintService(carpark.getAmountCars() + " Autos sind im Parkhaus");
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
