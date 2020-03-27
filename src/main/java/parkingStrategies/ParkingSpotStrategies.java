package main.java.parkingStrategies;

import main.java.Floor;

import java.util.List;

public enum ParkingSpotStrategies {

	FIRST_FLOOR_FIRST_SPOT(new FirstFloorFirstSpotStrategy()),
	FIRST_FLOOR_LAST_SPOT(new FirstFloorLastSpotStrategy()),
	LAST_FLOOR_LAST_SPOT(new LastFloorLastSpotStrategy()),
	LAST_FLOOR_FIST_SPOT(new LastFloorFirstSpotStrategy()),
	RANDOMLY(new RandomParkingSpotStrategy());

	private ParkingSpotStrategy parkingSpotStrategy;

	ParkingSpotStrategies(ParkingSpotStrategy parkingSpotStrategy) {
		this.parkingSpotStrategy = parkingSpotStrategy;
	}

	public void getParkingSpot(List<Floor> floors, String type){
		parkingSpotStrategy.getParkingSpot(floors, type);
	}
}
