package main.java.services;

import main.java.Carpark;
import main.java.Floor;
import main.java.vehicles.Vehicle;

public class ParkingService {

	private Carpark carpark;
	private CarparkService carparkService;

	public ParkingService(Carpark carpark, CarparkService carparkService) {
		this.carpark = carpark;
		this.carparkService = carparkService;
	}

	public void takeParkingSpot(String licensePlate, int parkingSpotId, int floorNr) {
		if (isParkingSuccessful(parkingSpotId, carparkService.getUnparkedVehicle(licensePlate), licensePlate, carpark.getFloor(floorNr))) {
			PrintService printService = new PrintService();
			printService.printSuccessMessage(printService.getActualMethodName());
		}
	}

	public boolean leaveParkingSpot(String licensePlate, int newParkingSpotId, int floorNr) {
		ResultService vehicle = carparkService.getParkedVehicle(licensePlate);
		Floor floor = carpark.getFloor(floorNr);
		if (vehicle.getParkingSpotId() == newParkingSpotId) {
			return unparking(newParkingSpotId, vehicle.getVehicle(), licensePlate, floor);
		}
		return false;
	}

	public Boolean isParkingSuccessful(int parkingSpotId, Vehicle vehicle, String licensePlate, Floor floor) {
		carpark.getUnparkedVehicles().remove(licensePlate, vehicle);
		carpark.putInParked(parkingSpotId, vehicle);
		floor.getParkingSpot(parkingSpotId).parking();
		return true;
	}

	public Boolean unparking(int parkingSpotId, Vehicle vehicle, String licensePlate, Floor floor) {
		carpark.getParkedVehicles().remove(parkingSpotId, vehicle);
		carpark.putInUnparked(licensePlate, vehicle);
		floor.getParkingSpot(parkingSpotId).leaving();
		return true;
	}
}
