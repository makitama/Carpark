package main.java.commandos.commandos;

import main.java.commandos.Commando;
import main.java.commandos.commandos.Factories.DriveInDriveOutCommandoParamsFactory;
import main.java.services.CarparkService;
import main.java.vehicles.Vehicle;
import main.java.vehicles.VehicleTypes;

import java.util.Map;

public class DriveInCommando implements Commando {

	private CarparkService carparkService;

	public DriveInCommando(CarparkService carparkService) {
		this.carparkService = carparkService;
	}

	@Override
	public void execute(Map<String, String> parameters) {
		DriveInDriveOutCommandoParamsFactory driveInDriveOutCommandoParamsFactory = new DriveInDriveOutCommandoParamsFactory(parameters);
		for (VehicleTypes possibleVehicleType : VehicleTypes.values()) {
			if (possibleVehicleType.getValue().equalsIgnoreCase(driveInDriveOutCommandoParamsFactory.getType())) {
				Vehicle vehicle = possibleVehicleType.createNewVehicle(driveInDriveOutCommandoParamsFactory);
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
