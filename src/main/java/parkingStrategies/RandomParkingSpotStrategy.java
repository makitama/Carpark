package main.java.parkingStrategies;

import main.java.Floor;
import main.java.ParkingSpot;

import java.util.Collections;
import java.util.List;

public class RandomParkingSpotStrategy implements ParkingSpotStrategy {

	@Override
	public int getParkingSpot(List<Floor> floors, String type) {
		Collections.shuffle(floors);
		List<ParkingSpot> parkingSpots = floors.get(0).getFreeParkingSpots(type);
		Collections.shuffle(parkingSpots);
		if (parkingSpots.isEmpty()) {
			return getParkingSpot(floors, type).getParkingSpotId();
		} else {
			// todo rekursion oder schleife??
			return parkingSpots.get(0).getParkingSpotId();
		}
	}
}
