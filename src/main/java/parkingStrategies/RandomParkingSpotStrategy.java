package parkingStrategies;

import carpark.Floor;
import carpark.ParkingSpot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomParkingSpotStrategy implements ParkingSpotStrategy {

	@Override
	public String getParkingSpot(List<Floor> floors, String type) {
		List<ParkingSpot> parkingSpots = new ArrayList<>();
		//todo überprüfen ob es überhaupt freie plätze gibt vorher => weil wegen rekursion/schleife!
		while (parkingSpots.isEmpty()) {
			Collections.shuffle(floors);
			parkingSpots = floors.get(0).getFreeParkingSpots(type);
			Collections.shuffle(parkingSpots);
		}
		return getParkingString(floors.get(0), parkingSpots.get(0));
	}

	@Override
	public String getParkingString(Floor floor, ParkingSpot parkingSpot) {
		return "Stockwerk #" + floor.getFloorNumber() + ", Parkplatz #" + parkingSpot.getParkingSpotId();
	}
}
