package commandos.commandos;

import commandos.Commando;
import commandos.commandos.Factories.DriveInDriveOutCommandoParamsFactory;
import exceptions.VehicleInFalseStateException;
import exceptions.VehicleNotInsideCarparkException;
import services.CarparkService;

import java.util.Map;

public class DriveOutCommando implements Commando {

	private CarparkService carparkService;

	public DriveOutCommando(CarparkService carparkService) {
		this.carparkService = carparkService;
	}

	@Override
	public void execute(Map<String, String> parameters) throws VehicleNotInsideCarparkException, VehicleInFalseStateException {
		DriveInDriveOutCommandoParamsFactory driveInDriveOutCommandoParamsFactory = new DriveInDriveOutCommandoParamsFactory(parameters);
		String success = carparkService.driveOut(driveInDriveOutCommandoParamsFactory, PRINT_TO_CONSOLE_SERVICE);
		PRINT_TO_CONSOLE_SERVICE.printSuccessMessage(success);
		DATABASE_SERVICE.deleteFromDatabase(driveInDriveOutCommandoParamsFactory.getLicense_plate());
	}

	@Override
	public String getDescription() {
		return "Fahrzeug fährt aus dem Parkhaus aus und wird gelöscht.";
	}

	@Override
	public String getParameterList() {
		return "type, color, license_plate. Bei Auto: height, manufacturer. Bei Motorrad: m_type";
	}
}
