package commandos;

import exceptions.NoParkingSpotOfVehicleFoundException;
import exceptions.VehicleInFalseStateException;
import exceptions.VehicleNotInsideCarparkException;
import services.Output.DatabaseService;
import services.Output.PrintToConsoleService;
import services.Output.PrintToFileService;

import java.util.Map;

public interface Commando {

	PrintToConsoleService PRINT_TO_CONSOLE_SERVICE = new PrintToConsoleService();
	PrintToFileService PRINT_TO_FILE_SERVICE = new PrintToFileService();
	DatabaseService DATABASE_SERVICE = new DatabaseService();

	void execute(Map<String, String> parameters) throws VehicleNotInsideCarparkException, VehicleInFalseStateException, NoParkingSpotOfVehicleFoundException;

	String getDescription();

	String getParameterList();
}
