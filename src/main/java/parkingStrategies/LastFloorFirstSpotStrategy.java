package main.java.parkingStrategies;

import main.java.Floor;

import java.util.List;

public class LastFloorFirstSpotStrategy implements ParkingSpotStrategy {


	@Override
	public int getParkingSpot(List<Floor> floors, String type) {
		for (int i = floors.size() - 1; i >= 0; i--) {
			if (floors.get(i).getFirstFreeParkingSpot(type) != null) {
				return floors.get(i).getFirstFreeParkingSpot(type).getParkingSpotId());
				//todo stockwerknummer?
			}
		}
	}
}
