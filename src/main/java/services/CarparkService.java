package main.java.services;

import main.java.Carpark;
import main.java.vehicles.Car;
import main.java.vehicles.Motorcycle;
import main.java.vehicles.Vehicle;

import java.util.Map;

public class CarparkService {

	private Carpark carpark;

	public CarparkService(Carpark carpark) {
		this.carpark = carpark;
	}

	public ResultService foundVehicle(Map<Integer, Vehicle> vehicles, String licensePlate){
		Vehicle vehicle;
		int parkingSpotId;
		for (Map.Entry lp : vehicles.entrySet()){
			if(((Vehicle)lp.getValue()).getLicenseplate().equalsIgnoreCase(licensePlate)){
				parkingSpotId = (int) lp.getKey();
				vehicle = (Vehicle) lp.getValue();
				return new ResultService(parkingSpotId, vehicle);
			}
		}
		throw new RuntimeException("Kein geparktes Fahrzeug gefunden");
	}

	public void listCars(Map<Integer, Vehicle> cars, ParkingSpotService parkingSpotService) {
		for (Vehicle vehicle : cars.values()) {
			if (vehicle instanceof Car) {
				new PrintService(vehicle.toString() + "Parkplatz: " + parkingSpotService.getParkingSpotOfVehicle(vehicle.getLicenseplate()));
			}
		}
		//TODO hier fehlen die Parkplätze als Ausgabe noch!
	}

	public void listMotorcycles(Map<Integer, Vehicle> mcycles, ParkingSpotService parkingSpotService) {
		for (Vehicle vehicle : mcycles.values()) {
			if (vehicle instanceof Motorcycle) {
				new PrintService(vehicle.toString() + "Parkplatz: " + parkingSpotService.getParkingSpotOfVehicle(vehicle.getLicenseplate()));
			}
		}
		//TODO hier fehlen die Parkplätze als Ausgabe noch!
	}

	public void listVehicles(Map<Integer, Vehicle> vehicles) {
		for (Vehicle vehicle : vehicles.values()) {
			new PrintService(vehicle.toString());
		}
		//TODO hier fehlen die Parkplätze als Ausgabe noch!
	}

	//TODO DriveIn überarbeiten!
	public void driveIn(Vehicle vehicle){
		for(Vehicle vehicle1 : carpark.getParkedVehicles().values()){
			if(vehicle1.getLicenseplate().equalsIgnoreCase(vehicle.getLicenseplate())){
				throw new RuntimeException("Ein Fahrzeug mit diesem Kennzeichen befindet sich bereits im Parkhaus");
			}
		}
		carpark.putInUnparked(vehicle.getLicenseplate(), vehicle);
		PrintService printservice = new PrintService();
		printservice.printSuccessMessage(new Object().getClass().getEnclosingMethod().getName());
	}
}
