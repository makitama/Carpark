package parkingStrategies;


import carpark.Floor;
import carpark.ParkingSpot;

import java.util.List;

public class LastFloorFirstSpotStrategy implements ParkingSpotStrategy {

	@Override
	public int getParkingSpot(List<Floor> floors, String type) {
		for (int i = floors.size() - 1; i >= 0; i--) {
			if (floors.get(i).getFirstFreeParkingSpot(type) != null) {
				return floors.get(i).getFirstFreeParkingSpot(type).getParkingSpotId();
				//todo stockwerknummer?
			}
		}
		//todo throw exception
		return 0;
	}
}
