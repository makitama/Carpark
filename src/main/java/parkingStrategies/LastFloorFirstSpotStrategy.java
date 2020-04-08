package parkingStrategies;


import carpark.Floor;
import carpark.ParkingSpot;

import java.util.List;

public class LastFloorFirstSpotStrategy implements ParkingSpotStrategy {

	@Override
	public String getParkingSpot(List<Floor> floors, String type) {
		for (int i = floors.size() - 1; i >= 0; i--) {
			if (floors.get(i).getFirstFreeParkingSpot(type) != null) {
				return getParkingString(floors.get(i), floors.get(i).getFirstFreeParkingSpot(type));
			}
		}
		return "Kein Parkplatz frei";
	}

	@Override
	public String getParkingString(Floor floor, ParkingSpot parkingSpot) {
		return "Stockwerk #" + floor.getFloorNumber() + ", Parkplatz #" + parkingSpot.getParkingSpotId();
	}
}
