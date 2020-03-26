package commandos.commandos;

import commandos.Commando;
import services.PrintService;

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
