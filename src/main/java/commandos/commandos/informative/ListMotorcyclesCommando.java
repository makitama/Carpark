package main.java.commandos.commandos.informative;

import main.java.commandos.Commando;
import main.java.services.CarparkService;

import java.io.IOException;
import java.util.Map;

public class ListMotorcyclesCommando implements Commando {

	private CarparkService carparkService;

	public ListMotorcyclesCommando(CarparkService carparkService) {
		this.carparkService = carparkService;
	}

	@Override
	public void execute(Map<String, String> parameters) {
		if (parameters.isEmpty()) {
			carparkService.listMotorcycles();
		} else {
			try {
				carparkService.listMotorcycles(parameters.get("FILE"));
			} catch (IOException ex) {
				System.err.println(ex.getMessage());
			}
		}
	}

	@Override
	public String getDescription() {
		return "Listet alle Motorräder im Parkhaus auf";
	}

	@Override
	public String getParameterList() {
		return "optional: file -> angabe Dateipfad";
	}
}
