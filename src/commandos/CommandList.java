package commandos;

import commandos.commandos.*;

import java.util.Map;

public class CommandList {

	Map <String, Commando> commandoMap;

	public CommandList(Map<String, Commando> commandoMap) {
		this.commandoMap = commandoMap;
	}

	private void getCommandos(){
		commandoMap.put("DRIVE_IN", new DriveInCommando());
		commandoMap.put("DRIVE_OUT", new DriveOutCommando());
		commandoMap.put("ENDE", new EndeCommando());
		commandoMap.put("PARKINGSPOTLEFT", new ParkingSpotLeftCommando());
		commandoMap.put("HELP", new HelpCommando());
	}
}
