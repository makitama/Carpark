package parkingStrategies;


import carpark.Floor;
import carpark.ParkingSpot;

import java.util.List;

public interface ParkingSpotStrategy {

	int getParkingSpot(List<Floor> floors, String type);

}
