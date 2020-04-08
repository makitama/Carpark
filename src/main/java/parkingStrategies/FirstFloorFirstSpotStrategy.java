package parkingStrategies;

import carpark.Floor;
import carpark.ParkingSpot;

import java.util.List;

public class FirstFloorFirstSpotStrategy implements ParkingSpotStrategy {

	@Override
	public String getParkingSpot(List<Floor> floors, String type) {
		for (Floor floor : floors) {
			if (floor.getFirstFreeParkingSpot(type) != null) {
				return getParkingString(floor, floor.getFirstFreeParkingSpot(type));
			}
		}
		return null;
		//todo exception
	}

	@Override
	public String getParkingString(Floor floor, ParkingSpot parkingSpot) {
		return "Stockwerk #" + floor.getFloorNumber() + ", Parkplatz #" + parkingSpot.getParkingSpotId();
	}
}
