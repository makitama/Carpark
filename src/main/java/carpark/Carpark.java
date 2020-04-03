package carpark;

import vehicles.Car;
import vehicles.Motorcycle;
import vehicles.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Carpark {

	private Map<Integer, Vehicle> parkedVehicles;
	private Map<String, Vehicle> unparkedVehicles;
	private List<Floor> floors;

	public Carpark(int floors, int carParkingSpots, int mcycleParkingSpots) {
		parkedVehicles = new HashMap<>();
		unparkedVehicles = new HashMap<>();
		this.floors = new ArrayList<>();
		for (int i = 1; i <= floors; i++) {
			this.floors.add(new Floor(carParkingSpots, mcycleParkingSpots, i));
		}
	}

	public Carpark(Map<String, Integer> configMap) {
		this(configMap.get("floors"), configMap.get("carParkingSpots"), configMap.get("mcycleParkingSpots"));
	}

	public String getWelcomeMessage() {
		String welcomeText = "Herzlich Willkommen im Parkhaus!";
		welcomeText += "\nBitte geben Sie ihren Befehl im Format <Befehlsname> <Param>=<Paramwert> ein:";
		welcomeText += "\nMöchten Sie die Application beenden, geben Sie bitte \"exit\" ein";
		welcomeText += "\nGeben Sie \"help\" ein, um eine Liste der einzelnen Commandos zu erhalten";
		return welcomeText;
	}

	public int getAmountVehicles() {
		return parkedVehicles.size() + unparkedVehicles.size();
	}

	public int getAmountMotorcycles() {
		return getMotorcycles().size();
	}

	public int getAmountCars() {
		return getCars().size();
	}

	public List<Vehicle> getAllVehiclesWithoutParkingSpots() {
		List<Vehicle> allVehicles = new ArrayList<>();
		parkedVehicles.entrySet().stream().forEach((Key) -> {
			allVehicles.add(Key.getValue());
		});
		unparkedVehicles.entrySet().stream().forEach((Key) -> {
			allVehicles.add(Key.getValue());
		});
		return allVehicles;
	}

	public Map<Integer, Vehicle> getParkedVehicles() {
		return parkedVehicles;
	}

	public Map<String, Vehicle> getUnparkedVehicles() {
		return unparkedVehicles;
	}

	public void putInUnparked(String licensePlate, Vehicle vehicle) {
		unparkedVehicles.put(licensePlate, vehicle);
	}

	public void putInParked(int parkingSpotId, Vehicle vehicle) {
		parkedVehicles.put(parkingSpotId, vehicle);
	}

	public void deleteCar(String licensePLate) {
		for (Vehicle vehicle : unparkedVehicles.values()) {
			if (vehicle.getLicenseplate().equalsIgnoreCase(licensePLate)) {
				unparkedVehicles.remove(vehicle.getLicenseplate(), vehicle);
			}
		}
	}

	public List<Vehicle> getCars() {
		List<Vehicle> cars = new ArrayList<>();
		if (!parkedVehicles.isEmpty()) {
			parkedVehicles.entrySet().stream().filter((Key) -> Key.getValue() instanceof Car).forEach((Key) -> {
				cars.add(Key.getValue());
			});
		}
		if (!unparkedVehicles.isEmpty()) {
			unparkedVehicles.entrySet().stream().filter((Key) -> Key.getValue() instanceof Car).forEach((Key) -> {
				cars.add(Key.getValue());
			});
		}
		return cars;
	}

	public List<Vehicle> getMotorcycles(){
		List<Vehicle> mcycles = new ArrayList<>();
		parkedVehicles.entrySet().stream().filter((Key) -> Key.getValue() instanceof Motorcycle).forEach((Key) -> mcycles.add(Key.getValue()));
		unparkedVehicles.entrySet().stream().filter((Key) -> Key.getValue() instanceof Motorcycle).forEach((Key) -> mcycles.add(Key.getValue()));
		return mcycles;
	}

	//todo needs to be tested!
	public List<Vehicle> getTypeOfVehicle(Object type){
		List<Vehicle> vehicles = new ArrayList<>();
		parkedVehicles.entrySet().stream().filter((Key) -> (Key.getValue()).equals(type)).forEach((Key) -> vehicles.add(Key.getValue()));
		unparkedVehicles.entrySet().stream().filter((Key) -> Key.getValue().equals(type)).forEach((Key) -> vehicles.add(Key.getValue()));
		return vehicles;
	}

	public List<Floor> getFloors() {
		return floors;
	}

	public Floor getFloor(int floorNumber) {
		List<Floor> floors = getFloors();
		for (Floor floor : floors) {
			if (floor.getFloorNumber() == floorNumber) {
				return floor;
			}
		}
		//todo no runtimeException
		throw new RuntimeException("Floor not found");
	}
}
