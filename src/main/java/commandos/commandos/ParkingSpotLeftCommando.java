package main.java.commandos.commandos;

import main.java.commandos.Commando;

import java.util.List;

public class ParkingSpotLeftCommando implements Commando {

	@Override
	public void execute(List<String> parameters) {

	}

	@Override
	public String getDescription() {
		return "Fahrzeug parkt ein";
	}

	@Override
	public String getParameterList() {
		return "necessary parameters: id of parkingspot, floorNr, license plate";
	}
}
