package services;

import carpark.Carpark;
import carpark.Floor;
import vehicles.Vehicle;
import vehicles.VehicleTypes;

public class ParkingService {

	private Carpark carpark;
	private CarparkService carparkService;

	public ParkingService(Carpark carpark, CarparkService carparkService) {
		this.carpark = carpark;
		this.carparkService = carparkService;
	}

	public boolean takeParkingSpot(String licensePlate, int parkingSpotId, int floorNr) {
		return isParkingSuccessful(parkingSpotId, carparkService.getUnparkedVehicle(licensePlate), licensePlate, carpark.getFloor(floorNr));
	}

	public boolean leaveParkingSpot(String licensePlate, int ParkingSpotId, int floorNr) {
		ResultService vehicle = carparkService.getParkedVehicle(licensePlate);
		Floor floor = carpark.getFloor(floorNr);
		if (vehicle.getParkingSpotId() == ParkingSpotId) {
			return unparking(ParkingSpotId, vehicle.getVehicle(), licensePlate, floor);
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

	public int[] getAmountFreeParkingSpots() {
		int[] amount = new int[2];
		int amountMotorcycles = 0;
		int amountCars = 0;
		for (Floor floor : carpark.getFloors()) {
			amountCars += floor.getFreeParkingSpots(VehicleTypes.CAR.toString()).size();
			amountMotorcycles += floor.getFreeParkingSpots(VehicleTypes.MOTORCYCLE.toString()).size();
		}
		amount[0] = amountCars;
		amount[1] = amountMotorcycles;
		return amount;
	}
}
