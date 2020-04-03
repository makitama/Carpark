package carpark;

import commandos.Commando;
import commandos.CommandoList;
import filehandling.ReadConfigFile;
import services.*;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class CarparkMain {

	private static final String nextCommand = "Und dann?";

	public static CommandoList initializing() throws IOException {
		ReadConfigFile properties = new ReadConfigFile();
		Carpark carpark = new Carpark(properties.getPropertyValues());
		new PrintService(carpark.getWelcomeMessage());

		ParkingSpotService parkingSpotService = new ParkingSpotService(carpark);
		CarparkService carparkService = new CarparkService(carpark, parkingSpotService);
		ParkingService parkingService = new ParkingService(carpark, carparkService);
		return new CommandoList(carpark, carparkService, parkingService, parkingSpotService);
	}

	public static void main(String[] args) throws IOException {
		CommandoList commandoList = initializing();
		Map<String, Commando> commandos = commandoList.getCommandoMap();
		CommandoService commandoService = new CommandoService();
		Scanner scanner = new Scanner(System.in);

		do {
			try {
				//Todo: validate();
				commandoService.commandoParser(scanner.nextLine());
				commandoService.checkIfCommandoExists(commandos);
				String commando = commandoService.getCommando();
				commandos.get(commando).execute(commandoService.getParameters());
				System.out.println(nextCommand);
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
				System.out.println(nextCommand);
			}
		} while(true);
	}
}
