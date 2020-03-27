package main.java.commandos.commandos;

import main.java.commandos.Commando;

import java.util.List;

public class DriveOutCommando implements Commando {
	@Override
	public void execute(List<String> parameters) {

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
