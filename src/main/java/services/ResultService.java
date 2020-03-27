package main.java.services;

import main.java.vehicles.Vehicle;

public class ResultService {

		private final int parkingSpotId;
		private final Vehicle vehicle;

		public ResultService(int parkingSpotId, Vehicle vehicle) {
			this.parkingSpotId = parkingSpotId;
			this.vehicle = vehicle;
		}

		public int getParkingSpotId() {
			return parkingSpotId;
		}

		public Vehicle getVehicle() {
			return vehicle;
		}

}
