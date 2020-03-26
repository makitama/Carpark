import vehicles.Car;
import vehicles.Motorcycle;
import vehicles.Vehicle;

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
		for (Vehicle vehicle : vehicles.keySet()) {
			if (vehicle instanceof Motorcycle) {
				amount++;
			}
		}
		return amount;
	}

	public int getAmountCars() {
		int amount = 0;
		for (Vehicle vehicle : vehicles.keySet()) {
			if (vehicle instanceof Car) {
				amount++;
			}
		}
		return amount;
	}

	public Map<Integer, Vehicle> getParkedVehicles() {
		return parkedVehicles;
	}

	public Map<Integer, Vehicle> getUnparkedVehicles() {
		return unparkedVehicles;
	}

	public Map<Integer, Vehicle> getAllVehicles() {
		Map<Integer, Vehicle> allVehicles = new HashMap<>();
		parkedVehicles.
	}

	public List<Floor> getFloors() {
		return floors;
	}

	public void listCars() {
		for (Vehicle vehicle : vehicles.keySet()) {
			if (vehicle instanceof Car) {
				System.out.println(vehicle.toString());
			}
		}
	}

	public void listMotorcycles() {
		for (Vehicle vehicle : vehicles.keySet()) {
			if (vehicle instanceof Motorcycle) {
				System.out.println(vehicle.toString());
			}
		}
	}

	public void listVehicles() {
		if (vehicles.isEmpty()) {
			//Error meldung rausgeben!
		}
		for (Vehicle vehicle : vehicles.keySet()) {
			System.out.println(vehicle.toString());
		}
	}


}
