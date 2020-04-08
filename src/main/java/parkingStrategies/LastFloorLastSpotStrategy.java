package parkingStrategies;


import carpark.Floor;
import carpark.ParkingSpot;

import java.util.List;

public class LastFloorLastSpotStrategy implements ParkingSpotStrategy {

	@Override
	public String getParkingSpot(List<Floor> floors, String type) {
		for (int i = floors.size() - 1; i >= 0; i--) {
			if (floors.get(i).getLastFreeParkingSpot(type) != null) {
				return getParkingString(floors.get(i), floors.get(i).getLastFreeParkingSpot(type));
			}
		}
		return "Kein Parkplatz frei";
	}

	@Override
	public String getParkingString(Floor floor, ParkingSpot parkingSpot) {
		return "Stockwerk #" + floor.getFloorNumber() + ", Parkplatz #" + parkingSpot.getParkingSpotId();
	}

}
