package exceptions;

public class NoParkingSpotOfVehicleFoundException extends Exception {

	public NoParkingSpotOfVehicleFoundException() {
	}

	public NoParkingSpotOfVehicleFoundException(String message) {
		super(message);
	}
}
