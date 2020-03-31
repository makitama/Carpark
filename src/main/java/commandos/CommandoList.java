package main.java.commandos;

import main.java.Carpark;
import main.java.commandos.commandos.*;
import main.java.services.CarparkService;
import main.java.services.ParkingService;
import main.java.services.ParkingSpotService;

import java.util.HashMap;
import java.util.Map;

public class CommandoList {

	private final Carpark carpark;
	private final CarparkService carparkService;
	private final ParkingService parkingService;
	private final ParkingSpotService parkingSpotService;
	private Map<String, Commando> commandoMap;

	public CommandoList(Carpark carpark, CarparkService carparkService, ParkingService parkingService, ParkingSpotService parkingSpotService) {
		this.carpark = carpark;
		this.carparkService = carparkService;
		this.parkingService = parkingService;
		this.parkingSpotService = parkingSpotService;
		getCommandos();
	}

	private void getCommandos() {
		commandoMap = new HashMap<>();
		commandoMap.put("DRIVE_IN", new DriveInCommando(carparkService));
		commandoMap.put("DRIVE_OUT", new DriveOutCommando(carparkService));
		commandoMap.put("EXIT", new ExitCommando());
		commandoMap.put("PARKINGSPOTLEFT", new ParkingSpotLeftCommando());
		commandoMap.put("HELP", new HelpCommando(commandoMap));
	}

	public Map<String, Commando> getCommandoMap(){
		return commandoMap;
	}
}
