package main.java.commandos.commandos;

import main.java.commandos.Commando;
import main.java.commandos.commandos.Factories.DriveInCommandoParamsFactory;
import main.java.services.CarparkService;
import main.java.vehicles.Vehicle;
import main.java.vehicles.VehicleTypes;

import java.util.List;

public class DriveInCommando implements Commando {

	private CarparkService carparkService;

	public DriveInCommando(CarparkService carparkService) {
		this.carparkService = carparkService;
	}

	@Override
	public void execute(List<String> parameters) {
		DriveInCommandoParamsFactory driveInCommandoParamsFactory = new DriveInCommandoParamsFactory(parameters);
		for (VehicleTypes possibleVehicleType : VehicleTypes.values()) {
			if (possibleVehicleType.getValue().equalsIgnoreCase(driveInCommandoParamsFactory.getType())) {
				Vehicle vehicle = possibleVehicleType.createNewVehicle(driveInCommandoParamsFactory);
				carparkService.driveIn(vehicle);
			}
		}
		//todo exception fahrzeug kann net im parkhaus parken
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
