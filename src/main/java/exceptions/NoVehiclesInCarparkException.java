package exceptions;

public class NoVehiclesInCarparkException extends Exception {

	public NoVehiclesInCarparkException() {
		super("Im Parkhaus befindne sich keine Fahrzeuge");
	}

	public NoVehiclesInCarparkException(String type) {
		super("Im Parkhaus befinden sich keine Fahrzeuge vom Typ: " + type);
	}
}
