package main.java.services;

import main.java.Carpark;
import main.java.Floor;
import main.java.parkingStrategies.ParkingSpotStrategies;
import main.java.vehicles.Vehicle;

import java.util.List;
import java.util.Map;

public class ParkingSpotService {

	private Carpark carpark;

	public ParkingSpotService(Carpark carpark) {
		this.carpark = carpark;
	}

	public void getParkingSpotSuggestion(String type, String strategy){
		List<Floor> floors = carpark.getFloors();
		ParkingSpotStrategies parkingStrategy = ParkingSpotStrategies.valueOf(strategy);
		parkingStrategy.getParkingSpot(floors, type);
	}

	public int getParkingSpotOfVehicle(String licensePlate){
		for(Map.Entry parkedVehicle: carpark.getParkedVehicles().entrySet()){
			if(((Vehicle) parkedVehicle.getValue()).getLicenseplate().equalsIgnoreCase(licensePlate)){
				return (int) parkedVehicle.getKey();
			}
		}
		//todo keine RuntimeException!
		throw new RuntimeException("Fahrzeug " + licensePlate + " nicht geparkt");
	}

}
