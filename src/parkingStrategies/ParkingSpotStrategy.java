package parkingStrategies;

import java.util.List;

public interface ParkingSpotStrategy {

	int getParkingSpot(List<Floor> floors, String type);

}
