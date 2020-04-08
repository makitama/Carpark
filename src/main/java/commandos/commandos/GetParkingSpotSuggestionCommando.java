package commandos.commandos;

import commandos.Commando;
import services.ParkingSpotService;

import java.util.Map;

public class GetParkingSpotSuggestionCommando implements Commando {

	ParkingSpotService parkingSpotService;

	public GetParkingSpotSuggestionCommando(ParkingSpotService parkingSpotService) {
		this.parkingSpotService = parkingSpotService;
	}

	@Override
	public void execute(Map<String, String> parameters) {
		PRINT_TO_CONSOLE_SERVICE.print("Vorgeschlagener Parkplatz lautet: " + parkingSpotService.getParkingSpotSuggestion(parameters.get("TYPE"),
			  parameters.get("STRATEGY")));
	}

	@Override
	public String getDescription() {
		return "Ausgabe eines Ziel-Parkplatzes für den angegebenenen Fahrzeugtyp mithilfe der übergebenen Strategie";
	}

	@Override
	public String getParameterList() {
		return "type, optional: strategy";
	}
}
