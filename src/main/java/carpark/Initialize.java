package carpark;

import commandos.CommandoList;
import filehandling.ReadConfigFile;
import services.CarparkService;
import services.Output.DatabaseService;
import services.Output.PrintToConsoleService;
import services.ParkingService;
import services.ParkingSpotService;

import java.io.IOException;
import java.util.List;

public class Initialize {

	CommandoList commandoList;
	Carpark carpark;

	public Initialize() throws IOException {
		this.commandoList = initializing();
		setDatabaseSettings();
	}

	public CommandoList getCommandoList() {
		return commandoList;
	}

	private CommandoList initializing() throws IOException {
		ReadConfigFile properties = new ReadConfigFile();
		carpark = new Carpark(properties.getPropertyValues());
		new PrintToConsoleService(carpark.getWelcomeMessage());

		ParkingSpotService parkingSpotService = new ParkingSpotService(carpark);
		CarparkService carparkService = new CarparkService(carpark, parkingSpotService);
		ParkingService parkingService = new ParkingService(carpark, carparkService);
		return new CommandoList(carpark, carparkService, parkingService, parkingSpotService);
	}

	private void setDatabaseSettings() {
		DatabaseService databaseService = new DatabaseService();
		databaseService.clearParkingSpotTable();
		List<Floor> floors = carpark.getFloors();
		for (Floor floor : floors) {
			for (ParkingSpot parkingSpot : floor.getParkingSpots()) {
				databaseService.putParkingSpotsInDatabase(floor.getFloorNumber(), parkingSpot.getParkingSpotId(), parkingSpot.getType());
			}
		}
	}

}
