package commandos.commandos;

import commandos.Commando;
import commandos.commandos.Factories.DriveInDriveOutCommandoParamsFactory;
import services.CarparkService;

import java.util.Map;

public class DriveOutCommando implements Commando {

	private CarparkService carparkService;

	public DriveOutCommando(CarparkService carparkService) {
		this.carparkService = carparkService;
	}

	@Override
	public void execute(Map<String, String> parameters) {
		DriveInDriveOutCommandoParamsFactory driveInDriveOutCommandoParamsFactory = new DriveInDriveOutCommandoParamsFactory(parameters);
		carparkService.driveOut(driveInDriveOutCommandoParamsFactory);
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
