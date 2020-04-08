package parkingStrategies;


import carpark.Floor;
import carpark.ParkingSpot;

import java.util.List;

public class FirstFloorLastSpotStrategy implements ParkingSpotStrategy {

	@Override
	public String getParkingSpot(List<Floor> floors, String type) {
		for (Floor floor : floors) {
			if (floor.getLastFreeParkingSpot(type) != null) {
				return getParkingString(floor, floor.getLastFreeParkingSpot(type));
			}
		}
		//todo throw new exception!
		return null;
	}

	@Override
	public String getParkingString(Floor floor, ParkingSpot parkingSpot) {
		return "Stockwerk #" + floor.getFloorNumber() + ", Parkplatz #" + parkingSpot.getParkingSpotId();
	}

}
