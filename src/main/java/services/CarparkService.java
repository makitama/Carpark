package main.java.services;

import main.java.Carpark;
import main.java.commandos.commandos.Factories.DriveInDriveOutCommandoParamsFactory;
import main.java.vehicles.Car;
import main.java.vehicles.Motorcycle;
import main.java.vehicles.Vehicle;

import java.util.Map;

public class CarparkService {

	private Carpark carpark;

	public CarparkService(Carpark carpark) {
		this.carpark = carpark;
	}

	public ResultService getParkedVehicle(String licensePlate) {
		Vehicle vehicle;
		int parkingSpotId;
		for (Map.Entry lp : carpark.getParkedVehicles().entrySet()) {
			if (((Vehicle) lp.getValue()).getLicenseplate().equalsIgnoreCase(licensePlate)) {
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
	public void driveIn(Vehicle vehicle) {
		for (Vehicle vehicle1 : carpark.getParkedVehicles().values()) {
			if (vehicle1.getLicenseplate().equalsIgnoreCase(vehicle.getLicenseplate())) {
				throw new RuntimeException("Ein Fahrzeug mit diesem Kennzeichen befindet sich bereits im Parkhaus");
			}
		}
		carpark.putInUnparked(vehicle.getLicenseplate(), vehicle);
		PrintService printservice = new PrintService();
		//String temp = new Object().getClass().getEnclosingMethod().getName();
		printservice.printSuccessMessage(printservice.getActualMethodName());
	}

	public void driveOut(DriveInDriveOutCommandoParamsFactory driveInDriveOutCommandoParamsFactory) {
		for (Vehicle vehicle1 : carpark.getUnparkedVehicles().values()) {
			if (vehicle1.getLicenseplate().equalsIgnoreCase(driveInDriveOutCommandoParamsFactory.getLicense_plate())) {
				//todo reicht hier das löschen aus der hashmap aus um das fahrzeug an sich zu löschen?
				carpark.deleteCar(driveInDriveOutCommandoParamsFactory.getLicense_plate());
			}
		}
		PrintService printservice = new PrintService();
		printservice.printSuccessMessage(printservice.getActualMethodName());
	}
}
