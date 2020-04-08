package exceptions;

public class VehicleInFalseStateException extends Exception {

	public VehicleInFalseStateException() {
	}

	public VehicleInFalseStateException(String message) {
		super(message);
	}

	public VehicleInFalseStateException(String vehicleInformations, String state) {
		super("The Vehicle with following informations is in state " + state + " and cannot execute the wanted operation. " + vehicleInformations);
	}
}
