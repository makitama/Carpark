package parkingStrategies;

import java.util.List;

public class FirstFloorLastSpotStrategy implements ParkingSpotStrategy {

	@Override
	public int getParkingSpot(List<Floor> floors, String type) {
		for (Floor floor : floors) {
			if (floor.getLastFreeParkingSpot(type) != null) {
				return floor.getLastFreeParkingSpot(type).getParkingSpotId();
				//todo stockwerknummer?
			}
		}
	}
}
