package parkingStrategies;

import java.util.List;

public class FirstFloorFirstSpotStrategy implements ParkingSpotStrategy {

	@Override
	public int getParkingSpot(List<Floor> floors, String type) {
		for (Floor floor : floors) {
			if (floor.getFirstFreeParkingSpot(type) != null) {
				return floor.getFirstFreeParkingSpot(type).getParkingSpotId();
				//todo stockwerknummer
			}
		}
	}

}
