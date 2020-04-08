package exceptions;

public class VehicleNotInsideCarparkException extends Exception {

	public VehicleNotInsideCarparkException(String vehicleInformations) {
		super("Das Fahrzeug mit folgenden Informationen befindet sich nicht im Parkhaus: " + vehicleInformations);
	}

	public VehicleNotInsideCarparkException() {
		super("Das Fahrzeug ist nicht im parkhaus");
	}
}
