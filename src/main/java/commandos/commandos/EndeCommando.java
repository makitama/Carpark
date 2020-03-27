package main.java.commandos.commandos;

import main.java.commandos.Commando;
import main.java.services.PrintService;

import java.util.List;

public class EndeCommando implements Commando {

	@Override
	public void execute(List<String> parameters) {
		new PrintService("Anwendung wird beendet");
		System.exit(0);
	}

	@Override
	public String getDescription() {
		return "Beendet die Anwendung";
	}

	@Override
	public String getParameterList() {
		return "Keine Parameter";
	}
}
