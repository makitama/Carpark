package commandos.commandos.informative;

import commandos.Commando;
import services.ParkingService;
import services.PrintService;

import java.util.Map;

public class GetAmountFreeParkingSpotsCommando implements Commando {

	ParkingService parkingService;

	public GetAmountFreeParkingSpotsCommando(ParkingService parkingService) {
		this.parkingService = parkingService;
	}

	@Override
	public void execute(Map<String, String> parameters) {
		new PrintService("Aktuell sind noch " + parkingService.getAmountFreeParkingSpots()[0] + " Autoparkplätze und " +
			  parkingService.getAmountFreeParkingSpots()[1] + " Motorradparkplätze verfügbar");
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
