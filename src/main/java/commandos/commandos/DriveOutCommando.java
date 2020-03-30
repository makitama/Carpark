package main.java.commandos.commandos;

import main.java.commandos.Commando;
import main.java.commandos.commandos.Factories.DriveInCommandoParamsFactory;
import main.java.services.CarparkService;

import java.util.List;

public class DriveOutCommando implements Commando {

	private CarparkService carparkService;

	public DriveOutCommando(CarparkService carparkService) {
		this.carparkService = carparkService;
	}

	@Override
	public void execute(List<String> parameters) {
		DriveInCommandoParamsFactory driveInCommandoParamsFactory = new DriveInCommandoParamsFactory(parameters);
		carparkService.driveOut(driveInCommandoParamsFactory);
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
