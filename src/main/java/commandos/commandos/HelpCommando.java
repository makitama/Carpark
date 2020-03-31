package main.java.commandos.commandos;


import main.java.commandos.Commando;
import main.java.services.PrintService;

import java.util.Map;

public class HelpCommando implements Commando {

	Map<String, Commando> commandoMap;

	public HelpCommando(Map<String, Commando> commandoMap) {
		this.commandoMap = commandoMap;
	}

	@Override
	public void execute(Map<String, String> parameters) {
		PrintService printService = new PrintService();
		printService.printFormattedDescription("Commando", "Beschreibung", "Parameter");
		commandoMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach((Key) -> {
			printService.printFormattedDescription(Key.getKey(), Key.getValue().getDescription(), Key.getValue().getParameterList());
		});
	}

	@Override
	public String getDescription() {
		return "Ausgabe Liste Befehle und Erklärung oder Parameter";
	}

	@Override
	public String getParameterList() {
		return "-";
	}
}
