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
		commandoMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach((Key) -> {
			(new PrintService()).printFormattedDescription(Key.getKey(), Key.getValue().getDescription());
		});
	}

	@Override
	public String getDescription() {
		return "Ausgabe Liste Befehle und Erklärung oder Parameter";
	}

	@Override
	public String getParameterList() {
		return null;
	}
}
