package main.java.commandos.commandos.informative;

import main.java.commandos.Commando;
import main.java.services.CarparkService;

import java.io.IOException;
import java.util.Map;

public class ListCarsCommando implements Commando {

	private CarparkService carparkService;

	public ListCarsCommando(CarparkService carparkService) {
		this.carparkService = carparkService;
	}

	@Override
	public void execute(Map<String, String> parameters) {
		if (parameters.isEmpty()) {
			carparkService.listCars();
		} else {
			try {
				carparkService.listCars(parameters.get("FILE"));
			} catch (IOException ex) {
				System.err.println(ex.getMessage());
			}
		}
	}

	@Override
	public String getDescription() {
		return "Listet alle Autos im Parkhaus auf";
	}

	@Override
	public String getParameterList() {
		return "optional: file -> angabe Dateipfad";
	}
}
