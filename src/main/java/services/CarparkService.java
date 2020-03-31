package main.java.services;

import main.java.Carpark;
import main.java.commandos.commandos.Factories.DriveInDriveOutCommandoParamsFactory;
import main.java.vehicles.Car;
import main.java.vehicles.Vehicle;

import java.io.IOException;
import java.util.Map;

public class CarparkService {

	private Carpark carpark;
	private ParkingSpotService parkingSpotService;

	public CarparkService(Carpark carpark, ParkingSpotService parkingSpotService) {
		this.carpark = carpark;
		this.parkingSpotService = parkingSpotService;
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

	public Vehicle getUnparkedVehicle(String licenseplate) {
		for (Vehicle vehicle1 : carpark.getUnparkedVehicles().values()) {
			if (vehicle1.getLicenseplate().equalsIgnoreCase(licenseplate)) {
				return vehicle1;
			}
		}
		throw new RuntimeException("Kein ungeparktes passendes Fahrzeug gefunden");
	}

	public void listCars() {
		for (Vehicle vehicle : carpark.getCars()) {
			if (vehicle instanceof Car) {
				new PrintService(vehicle.toString() + parkingSpotOfVehicleIfVehicleIsParked(vehicle.getLicenseplate()));
			}
		}
		//TODO was wenn keine autos geparkt sind => ausgabe meldung
	}

	public void listCars(String file) throws IOException {
		for (Vehicle vehicle : carpark.getCars()) {
			if (vehicle instanceof Car) {
				new PrintService().printToFile(file, vehicle.toString() + parkingSpotOfVehicleIfVehicleIsParked(vehicle.getLicenseplate()));
			}
		}
		//TODO was wenn keine autos geparkt sind => ausgabe meldung
	}

	public String parkingSpotOfVehicleIfVehicleIsParked(String licenseplate) {
		int id = parkingSpotService.getParkingSpotOfVehicle(licenseplate);
		return ((id > 0) ? ", Parkplatz: " + id : ", nicht geparkt");
	}

	public void listMotorcycles() {
		for (Vehicle vehicle : carpark.getMotorcycles()) {
			new PrintService(vehicle.toString() + parkingSpotOfVehicleIfVehicleIsParked(vehicle.getLicenseplate()));
		}
		//TODO was wenn keine motoräder da sind. => Ausgabe meldung
	}

	public void listMotorcycles(String file) throws IOException {
		for (Vehicle vehicle : carpark.getMotorcycles()) {
			(new PrintService()).printToFile(file, vehicle.toString() + parkingSpotOfVehicleIfVehicleIsParked(vehicle.getLicenseplate()));
		}
		//TODO was wenn keine motoräder da sind. => Ausgabe meldung
	}


	public void listVehicles() {
		for (Vehicle vehicle : carpark.getAllVehiclesWithoutParkingSpots()) {
			new PrintService(vehicle.toString() + parkingSpotOfVehicleIfVehicleIsParked(vehicle.getLicenseplate()));
		}
		//TODO was wenn keine fahrzeuge da sind => Ausgabe meldung
	}

	public void listVehicles(String file) throws IOException {
		for (Vehicle vehicle : carpark.getAllVehiclesWithoutParkingSpots()) {
			(new PrintService()).printToFile(file, vehicle.toString() + parkingSpotOfVehicleIfVehicleIsParked(vehicle.getLicenseplate()));
		}
		//TODO was wenn keine fahrzeuge da sind => Ausgabe meldung
	}

	//TODO DriveIn überarbeiten!
	public void driveIn(Vehicle vehicle) {
		for (Vehicle vehicle1 : carpark.getAllVehiclesWithoutParkingSpots()) {
			if (vehicle1.getLicenseplate().equalsIgnoreCase(vehicle.getLicenseplate())) {
				throw new RuntimeException("Ein Fahrzeug mit diesem Kennzeichen befindet sich bereits im Parkhaus");
			}
		}
		carpark.putInUnparked(vehicle.getLicenseplate(), vehicle);
		PrintService printservice = new PrintService();
		printservice.printSuccessMessage(printservice.getActualMethodName());
	}

	public void driveOut(DriveInDriveOutCommandoParamsFactory driveInDriveOutCommandoParamsFactory) {
		for (Vehicle vehicle1 : carpark.getUnparkedVehicles().values()) {
			if (vehicle1.getLicenseplate().equalsIgnoreCase(driveInDriveOutCommandoParamsFactory.getLicense_plate())) {
				//todo reicht hier das löschen aus der hashmap aus um das fahrzeug an sich zu löschen?
				carpark.deleteCar(driveInDriveOutCommandoParamsFactory.getLicense_plate());
				PrintService printservice = new PrintService();
				printservice.printSuccessMessage(printservice.getActualMethodName());
			}
		}
		//todo print message kein auto gefunden!
		//todo in parking cars schauen ob da auto gefunden => entsprechende meldung ausgeben!
	}
}
