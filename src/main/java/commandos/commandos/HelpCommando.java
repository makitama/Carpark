package main.java.commandos.commandos;


import main.java.commandos.Commando;
import main.java.services.PrintService;

import java.util.List;
import java.util.Map;

public class HelpCommando implements Commando {

	Map<String, Commando> commandoMap;

	@Override
	public void execute(List<String> parameters) {
		commandoMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach((Key) -> {
			System.out.printf("%-32s|%-32s\n", Key.getKey(), " " + Key.getValue().getDescription());
			//Todo ausgabe trennen!
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
