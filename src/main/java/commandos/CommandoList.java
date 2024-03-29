package commandos;


import carpark.Carpark;
import commandos.commandos.*;
import commandos.commandos.informative.*;
import services.CarparkService;
import services.ParkingService;
import services.ParkingSpotService;

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
		commandoMap.put("PARKING_SPOT_LEFT", new ParkingSpotLeftCommando(parkingService));
		commandoMap.put("PARKING_SPOT_TAKEN", new ParkingSpotTakenCommando(parkingService));
		commandoMap.put("HELP", new HelpCommando(commandoMap));
		commandoMap.put("LIST_CARS", new ListCarsCommando(carparkService, carpark));
		commandoMap.put("LIST_MOTORCYCLES", new ListMotorcyclesCommando(carparkService, carpark));
		commandoMap.put("LIST_VEHICLES", new ListVehiclesCommando(carparkService, carpark));
		commandoMap.put("GET_AMOUNT_CARS", new GetAmountCarsCommando(carpark));
		commandoMap.put("GET_AMOUNT_MOTORCYCLES", new GetAmountMotorcyclesCommando(carpark));
		commandoMap.put("GET_PARKING_SPOT_OF_VEHICLE", new GetParkingSpotOfVehicleCommando(carparkService));
		commandoMap.put("GET_AMOUNT_FREE_PARKING_SPOTS", new GetAmountFreeParkingSpotsCommando(parkingService));
		commandoMap.put("GET_AMOUNT_VEHICLES", new GetAmountVehiclesCommando(carpark));
		commandoMap.put("GET_PARKING_SPOT_SUGGESTION", new GetParkingSpotSuggestionCommando(parkingSpotService));
	}

	public Map<String, Commando> getCommandoMap(){
		return commandoMap;
	}
}
