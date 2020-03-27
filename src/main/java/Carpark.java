package main.java;

import main.java.services.PrintService;
import main.java.vehicles.Car;
import main.java.vehicles.Motorcycle;
import main.java.vehicles.Vehicle;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Carpark {

	private Map<Integer, Vehicle> parkedVehicles;
	private Map<Integer, Vehicle> unparkedVehicles;
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

	public int getAmountVehicles() {
		return parkedVehicles.size() + unparkedVehicles.size();
	}

	public int getAmountMotorcycles() {
		int amount = 0;
		for (Vehicle vehicle : getAllVehiclesWithoutParkingSpots()) {
			if (vehicle instanceof Motorcycle) {
				amount++;
			}
		}
		return amount;
	}

	public int getAmountCars() {
		int amount = 0;
		List<Vehicle> allVehicles = getAllVehiclesWithoutParkingSpots();
		for (Vehicle vehicle : allVehicles) {
			if (vehicle instanceof Car) {
				amount++;
			}
		}
		return amount;
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

	public Map<Integer, Vehicle> getUnparkedVehicles() {
		return unparkedVehicles;
	}

	public Map<Integer, Vehicle> getAllVehicles() {
		Map<Integer, Vehicle> allVehicles = new HashMap<>();
		parkedVehicles.entrySet().stream().forEach((Key) -> {
			allVehicles.put(Key.getKey(), Key.getValue());
		});
		unparkedVehicles.entrySet().stream().forEach((Key) -> {
			allVehicles.put(Key.getKey(), Key.getValue());
		});
		return allVehicles;
	}

	public Map<Integer, Vehicle> getCars() {
		Map<Integer, Vehicle> cars = new HashMap<>();
		parkedVehicles.entrySet().stream().filter((Key) -> Key.getValue() instanceof Car).forEach((Key) -> {
			cars.put(Key.getKey(), Key.getValue());
		});
		unparkedVehicles.entrySet().stream().filter((Key) -> Key.getValue() instanceof Car).forEach((Key) -> {
			cars.put(Key.getKey(), Key.getValue());
		});
		return cars;
	}

	public List<Floor> getFloors() {
		return floors;
	}

	public Floor getFloor(int floorNumber){
		List<Floor> floors = getFloors();
		for(Floor floor : floors){
			if(floor.getFloorNumber() == floorNumber){
				return floor;
			}
		}
		//todo no runtimeException
		throw new RuntimeException("Floor not found");
	}


}
