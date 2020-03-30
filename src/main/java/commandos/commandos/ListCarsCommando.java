package main.java.commandos.commandos;

import main.java.commandos.Commando;
import main.java.services.CarparkService;
import main.java.services.ParkingSpotService;

import java.util.Map;

public class ListCarsCommando implements Commando {

	private CarparkService carparkService;
	private ParkingSpotService parkingSpotService;

	public ListCarsCommando(CarparkService carparkService) {
		this.carparkService = carparkService;
	}

	@Override
	public void execute(Map<String, String> parameters) {
		carparkService.listCars(parkingSpotService);
	}

	@Override
	public String getDescription() {
		return "Listet alle Autos im Parkhaus auf";
	}

	@Override
	public String getParameterList() {
		return "";
	}
}
