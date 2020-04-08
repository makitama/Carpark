package services;


import carpark.Carpark;
import commandos.commandos.Factories.DriveInDriveOutCommandoParamsFactory;
import exceptions.NoParkingSpotOfVehicleFoundException;
import exceptions.VehicleInFalseStateException;
import exceptions.VehicleNotInsideCarparkException;
import services.Output.OutputService;
import vehicles.Car;
import vehicles.Vehicle;

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

	public void listCars(OutputService outputService) throws NoParkingSpotOfVehicleFoundException {
		for (Vehicle vehicle : carpark.getCars()) {
			if (vehicle instanceof Car) {
				outputService.print(vehicle.toString() + parkingSpotOfVehicleIfVehicleIsParked(vehicle.getLicenseplate()));
			}
		}
		//TODO was wenn keine autos geparkt sind => ausgabe meldung
	}

	public void listCars(String file, OutputService outputService) throws IOException, NoParkingSpotOfVehicleFoundException {
		for (Vehicle vehicle : carpark.getCars()) {
			if (vehicle instanceof Car) {
				outputService.print(file, vehicle.toString() + parkingSpotOfVehicleIfVehicleIsParked(vehicle.getLicenseplate()));
			}
		}
		//TODO was wenn keine autos geparkt sind => ausgabe meldung
	}

	public String parkingSpotOfVehicleIfVehicleIsParked(String licenseplate) throws NoParkingSpotOfVehicleFoundException {
		int id = parkingSpotService.getParkingSpotOfVehicle(licenseplate);
		return ((id > 0) ? ", parkt auf Parkplatz #" + id : ", ist nicht geparkt");
	}

	public void listMotorcycles(OutputService outputService) throws NoParkingSpotOfVehicleFoundException {
		for (Vehicle vehicle : carpark.getMotorcycles()) {
			outputService.printToConsole(vehicle.toString() + parkingSpotOfVehicleIfVehicleIsParked(vehicle.getLicenseplate()));
		}
		//TODO was wenn keine motoräder da sind. => Ausgabe meldung
	}

	public void listMotorcycles(String file, OutputService outputService) throws IOException, NoParkingSpotOfVehicleFoundException {
		for (Vehicle vehicle : carpark.getMotorcycles()) {
			outputService.print(file, vehicle.toString() + parkingSpotOfVehicleIfVehicleIsParked(vehicle.getLicenseplate()));
		}
		//TODO was wenn keine motoräder da sind. => Ausgabe meldung
	}


	public void listVehicles(OutputService outputService) throws NoParkingSpotOfVehicleFoundException {
		for (Vehicle vehicle : carpark.getAllVehiclesWithoutParkingSpots()) {
			outputService.printToConsole(vehicle.toString() + parkingSpotOfVehicleIfVehicleIsParked(vehicle.getLicenseplate()));
		}
		//TODO was wenn keine fahrzeuge da sind => Ausgabe meldung
	}

	public void listVehicles(String file, OutputService outputService) throws IOException, NoParkingSpotOfVehicleFoundException {
		for (Vehicle vehicle : carpark.getAllVehiclesWithoutParkingSpots()) {
			outputService.print(file, vehicle.toString() + parkingSpotOfVehicleIfVehicleIsParked(vehicle.getLicenseplate()));
		}
		//TODO was wenn keine fahrzeuge da sind => Ausgabe meldung
	}

	//TODO DriveIn überarbeiten!
	public void driveIn(Vehicle vehicle, OutputService outputService) {
		for (Vehicle vehicle1 : carpark.getAllVehiclesWithoutParkingSpots()) {
			if (vehicle1.getLicenseplate().equalsIgnoreCase(vehicle.getLicenseplate())) {
				throw new RuntimeException("Ein Fahrzeug mit diesem Kennzeichen befindet sich bereits im Parkhaus");
			}
		}
		carpark.putInUnparked(vehicle.getLicenseplate(), vehicle);
	}

	public void driveOut(DriveInDriveOutCommandoParamsFactory driveInDriveOutCommandoParamsFactory, OutputService outputService) throws VehicleNotInsideCarparkException, VehicleInFalseStateException {
		for (Vehicle vehicle1 : carpark.getUnparkedVehicles().values()) {
			if (vehicle1.getLicenseplate().equalsIgnoreCase(driveInDriveOutCommandoParamsFactory.getLicense_plate())) {
				carpark.deleteCar(driveInDriveOutCommandoParamsFactory.getLicense_plate());
			}
		}
		for (Vehicle vehicle1 : carpark.getParkedVehicles().values()) {
			if (vehicle1.getLicenseplate().equalsIgnoreCase(driveInDriveOutCommandoParamsFactory.getLicense_plate())) {
				throw new VehicleInFalseStateException("parked");
			}
		}
		throw new VehicleNotInsideCarparkException();
	}
}
