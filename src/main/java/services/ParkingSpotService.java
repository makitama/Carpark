package services;

import carpark.Carpark;
import carpark.Floor;
import exceptions.NoParkingSpotOfVehicleFoundException;
import parkingStrategies.ParkingSpotStrategies;
import vehicles.Vehicle;

import java.util.List;
import java.util.Map;

public class ParkingSpotService {

	private Carpark carpark;

	public ParkingSpotService(Carpark carpark) {
		this.carpark = carpark;
	}

	public String getParkingSpotSuggestion(String type, String strategy) {
		List<Floor> floors = carpark.getFloors();
		ParkingSpotStrategies parkingStrategy = ParkingSpotStrategies.valueOf(strategy);
		return parkingStrategy.getParkingSpot(floors, type);
	}

	public int getParkingSpotOfVehicle(String licensePlate) throws NoParkingSpotOfVehicleFoundException {
		for (Map.Entry parkedVehicle : carpark.getParkedVehicles().entrySet()) {
			if (((Vehicle) parkedVehicle.getValue()).getLicenseplate().equalsIgnoreCase(licensePlate)) {
				return (int) parkedVehicle.getKey();
			}
		}
		throw new NoParkingSpotOfVehicleFoundException();
	}

}
