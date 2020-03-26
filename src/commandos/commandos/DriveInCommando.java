package commandos.commandos;

import commandos.Commando;

import java.util.List;

public class DriveInCommando implements Commando {
	@Override
	public void execute(List<String> parameters) {

	}

	@Override
	public String getDescription() {
		return "Fahrzeug fährt in Parkhaus ein";
	}

	@Override
	public String getParameterList() {
		return "";
	}


}
