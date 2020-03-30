package main.java.commandos.commandos;

import main.java.commandos.Commando;
import main.java.commandos.commandos.Factories.DriveInDriveOutCommandoParamsFactory;
import main.java.services.CarparkService;

import java.util.Map;

public class DriveOutCommando implements Commando {

	private CarparkService carparkService;

	public DriveOutCommando(CarparkService carparkService) {
		this.carparkService = carparkService;
	}

	@Override
	public void execute(Map<String, String> parameters) {
		DriveInDriveOutCommandoParamsFactory driveInDriveOutCommandoParamsFactory = new DriveInDriveOutCommandoParamsFactory(parameters);
		carparkService.driveOut(driveInDriveOutCommandoParamsFactory);
	}

	@Override
	public String getDescription() {
		return "Fahrzeug fährt aus dem Parkhaus aus und wird gelöscht.";
	}

	@Override
	public String getParameterList() {
		return null;
	}
}
