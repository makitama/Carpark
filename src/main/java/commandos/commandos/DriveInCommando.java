package main.java.commandos.commandos;

import main.java.vehicles.VehicleTypes;
import main.java.commandos.Commando;
import main.java.services.CarparkService;
import main.java.vehicles.Vehicle;

import java.util.List;

public class DriveInCommando implements Commando {
	@Override
	public void execute(List<String> parameters) {

	}

	@Override
	public String getDescription() {
		return "Fahrzeug fährt in Parkhaus ein";
	}

	@Override
	public String getParameterList() {
		return "";
	}


}
