package parkingStrategies;

import carpark.Floor;

import java.util.List;

public enum ParkingSpotStrategies {

	FIRST_FLOOR_FIRST_SPOT(new FirstFloorFirstSpotStrategy()),
	FIRST_FLOOR_LAST_SPOT(new FirstFloorLastSpotStrategy()),
	LAST_FLOOR_LAST_SPOT(new LastFloorLastSpotStrategy()),
	LAST_FLOOR_FIRST_SPOT(new LastFloorFirstSpotStrategy()),
	RANDOMLY(new RandomParkingSpotStrategy());

	private ParkingSpotStrategy parkingSpotStrategy;

	ParkingSpotStrategies(ParkingSpotStrategy parkingSpotStrategy) {
		this.parkingSpotStrategy = parkingSpotStrategy;
	}

	public String getParkingSpot(List<Floor> floors, String type) {
		return parkingSpotStrategy.getParkingSpot(floors, type);
	}
}
