package main.java.parkingStrategies;

import main.java.Floor;

import java.util.List;

public interface ParkingSpotStrategy {

	int getParkingSpot(List<Floor> floors, String type);

}
