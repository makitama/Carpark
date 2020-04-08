package parkingStrategies;


import carpark.Floor;
import carpark.ParkingSpot;

import java.util.List;

public interface ParkingSpotStrategy {

	String getParkingSpot(List<Floor> floors, String type);

	String getParkingString(Floor floor, ParkingSpot parkingSpot);

}
