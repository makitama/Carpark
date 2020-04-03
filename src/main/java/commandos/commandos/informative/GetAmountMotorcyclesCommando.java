package commandos.commandos.informative;

import carpark.Carpark;
import commandos.Commando;
import services.PrintService;

import java.util.Map;

public class GetAmountMotorcyclesCommando implements Commando {

	Carpark carpark;

	public GetAmountMotorcyclesCommando(Carpark carpark) {
		this.carpark = carpark;
	}

	@Override
	public void execute(Map<String, String> parameters) {
		new PrintService(carpark.getAmountMotorcycles() + " Motorräder im Parkhaus");
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
