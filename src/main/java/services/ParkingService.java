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

	public boolean takeParkingSpot(String licensePlate, int newParkingSpotId, int floorNr) {
		return park(licensePlate, newParkingSpotId, floorNr, "park");
	}

	public boolean leaveParkingSpot(String licensePlate, int newParkingSpotId, int floorNr) {
		return park(licensePlate, newParkingSpotId, floorNr, "unpark");
	}

	private boolean park(String licensePlate, int parkingSpotId, int floorNr, String park) {
		return assignParkingSpotToCar(licensePlate, parkingSpotId, park, floorNr);
	}

	private Boolean assignParkingSpotToCar(String licensePlate, int parkingSpotId, String operation, int floorNumber){
		ResultService vehicle = carparkService.foundVehicle(carpark.getParkedVehicles(), licensePlate);
		Floor floor = carpark.getFloor(floorNumber);
		if(operation.equalsIgnoreCase("unparking") && vehicle.getParkingSpotId() == parkingSpotId){
			return unparking(parkingSpotId, vehicle.getVehicle(), licensePlate, floor);
		} else if(operation.equalsIgnoreCase("parking")){
			return parking(parkingSpotId, vehicle.getVehicle(), licensePlate, floor);
		} else{
			return false;
		}
	}

	public Boolean parking(int parkingSpotId, Vehicle vehicle, String licensePlate, Floor floor){
		carpark.getUnparkedVehicles().remove(licensePlate, vehicle);
		carpark.putInParked(parkingSpotId, vehicle);
		floor.getParkingSpot(parkingSpotId).parking();
		return true;
	}

	public Boolean unparking(int parkingSpotId, Vehicle vehicle, String licensePlate, Floor floor){
		carpark.getParkedVehicles().remove(parkingSpotId, vehicle);
		carpark.putInUnparked(licensePlate, vehicle);
		floor.getParkingSpot(parkingSpotId).leaving();
		return true;
	}
}
