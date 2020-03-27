package main.java.commandos;

import main.java.Carpark;
import main.java.commandos.commandos.*;
import main.java.services.CarparkService;
import main.java.services.ParkingService;
import main.java.services.ParkingSpotService;

import java.util.HashMap;
import java.util.Map;

public class CommandoList {

	private Map<String, Commando> commandoMap;
	private final Carpark carpark;
	private final CarparkService carparkService;
	private final ParkingService parkingService;
	private final ParkingSpotService parkingSpotService;

	public CommandoList(Carpark carpark,  CarparkService carparkService, ParkingService parkingService, ParkingSpotService parkingSpotService) {
		this.carpark = carpark;
		this.carparkService = carparkService;
		this.parkingService = parkingService;
		this.parkingSpotService = parkingSpotService;
		getCommandos();
	}

	private void getCommandos() {
		commandoMap = new HashMap<>();
		commandoMap.put("DRIVE_IN", new DriveInCommando(carparkService));
		commandoMap.put("DRIVE_OUT", new DriveOutCommando());
		commandoMap.put("ENDE", new EndeCommando());
		commandoMap.put("PARKINGSPOTLEFT", new ParkingSpotLeftCommando());
		commandoMap.put("HELP", new HelpCommando());
	}

	public Map<String, Commando> getCommandoMap(){
		return commandoMap;
	}
}
