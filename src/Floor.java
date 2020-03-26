import java.util.ArrayList;
import java.util.List;

public class Floor {

	private List<ParkingSpot> parkingSpots;
	private int floorNumber;

	public Floor(int carParkingSpots, int mcycleParkingSpots, int floorNumber) {
		parkingSpots = new ArrayList<>();
		int idNr = 001;
		for (int i = 0; i < carParkingSpots; i++) {
			parkingSpots.add(new ParkingSpot(idNr++, ParkingSpotTypes.CAR.toString(), false));
			System.out.println(idNr);
		}
		for (int i = 1; i <= mcycleParkingSpots; i++) {
			parkingSpots.add(idNr++, ParkingSpotTypes.MOTORCYCLE.toString(), false);
			System.out.println(idNr);
		}
	}

	public List<ParkingSpot> getFreeParkingSpots(String type) {
		List<ParkingSpot> freeSpots = new ArrayList<>();
		for (ParkingSpot parkingSpot : parkingSpots) {
			if (!parkingSpot.isTaken() && parkingSpot.getType().equalsIgnoreCase(type)) {
				freeSpots.add(parkingSpot)
			}
		}
		if (!freeSpots.isEmpty()) {
			return freeSpots;
		}
		throw new RuntimeException("Das Stockwerk #" + floorNumber + " ist vollgeparkt");
	}

	public ParkingSpot getFirstFreeParkingSpot(String type) {
		return getFreeParkingSpots(type).get(0);
	}

	public ParkingSpot getLastFreeParkingSpot(String type) {
		List<ParkingSpot> parkingSpots = getFreeParkingSpots(type);
		return getParkingSpot(parkingSpots.get(parkingSpots.size() - 1).getParkingSpotId());
	}
}
