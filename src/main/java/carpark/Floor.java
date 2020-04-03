package carpark;

import vehicles.VehicleTypes;

import java.util.ArrayList;
import java.util.List;

public class Floor {

	private List<ParkingSpot> parkingSpots;
	private int floorNumber;

	public Floor(int carParkingSpots, int mcycleParkingSpots, int floorNumber) {
		this.floorNumber = floorNumber;
		parkingSpots = new ArrayList<>();
		int idNr = 001;
		for (int i = 0; i < carParkingSpots; i++) {
			parkingSpots.add(new ParkingSpot(idNr++, VehicleTypes.CAR.toString(), false));
		}
		for (int i = 1; i <= mcycleParkingSpots; i++) {
			parkingSpots.add(new ParkingSpot(idNr++, VehicleTypes.MOTORCYCLE.toString(), false));
		}
	}

	public List<ParkingSpot> getFreeParkingSpots(String type) {
		List<ParkingSpot> freeSpots = new ArrayList<>();
		for (ParkingSpot parkingSpot : parkingSpots) {
			if (parkingSpot.isFree() && parkingSpot.getType().equalsIgnoreCase(type)) {
				freeSpots.add(parkingSpot);
			}
		}
		if (!freeSpots.isEmpty()) {
			return freeSpots;
		}
		return new ArrayList<>();
	}

	public ParkingSpot getFirstFreeParkingSpot(String type) {
		return getFreeParkingSpots(type).get(0);
	}

	public ParkingSpot getLastFreeParkingSpot(String type) {
		List<ParkingSpot> parkingSpots = getFreeParkingSpots(type);
		return getParkingSpot(parkingSpots.get(parkingSpots.size() - 1).getParkingSpotId());
	}

	public ParkingSpot getParkingSpot(int parkingSpotId) {
		for (ParkingSpot parkingSpot : parkingSpots) {
			if (parkingSpot.getParkingSpotId() == parkingSpotId) {
				return parkingSpot;
			}
		}
		//Todo keine runtimeexception schmeißen => Custom Exception
		throw new RuntimeException("Parkplatz #" + floorNumber + "" + parkingSpotId + "exisitert nicht");
	}

	public int getAmountFreeParkingSpots() {
		int amount = 0;
		for (ParkingSpot parkingSpot : parkingSpots) {
			if (parkingSpot.isFree()) {
				amount++;
			}
		}
		return amount;
	}

	public int getFloorNumber() {
		return floorNumber;
	}
}
