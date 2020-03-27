package main.java;

import main.java.commandos.Commando;
import main.java.commandos.CommandoList;
import main.java.filehandling.ReadConfigFile;
import main.java.services.CarparkService;
import main.java.services.CommandoService;
import main.java.services.ParkingService;
import main.java.services.ParkingSpotService;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class CarparkMain {

	private static final String nextCommand = "Und dann?";

	public static void printWelcomeMessage(){
		//TODO hier oder in eigener klasse? Darf die main methoden und attribute enthalten
		System.out.println("Herzlich Willkommen im Parkhaus!");
		System.out.println("Bitte geben Sie ihren Befehl im Format <Befehlsname> <Param>=<Paramwert> ein:");
		System.out.println("Möchten Sie die Application beenden, geben Sie bitte \"ende\" ein");
		System.out.println("Geben Sie \"help\" ein, um eine Liste der einzelnen Commandos zu erhalten");
	}

	public static CommandoList initializeCommandoList() throws IOException {
		ReadConfigFile properties = new ReadConfigFile();
		Carpark carpark = new Carpark(properties.getPropertyValues());
		CarparkService carparkService = new CarparkService(carpark);
		ParkingService parkingService = new ParkingService(carpark, carparkService);
		ParkingSpotService parkingSpotService = new ParkingSpotService(carpark);
		return new CommandoList(carpark, carparkService, parkingService, parkingSpotService);
	}

	public static void main(String[] args) throws IOException {
		printWelcomeMessage();
		CommandoList commandoList = initializeCommandoList();
		Map<String, Commando> commandos = commandoList.getCommandoMap();
		CommandoService commandoService = new CommandoService();
		Scanner scanner = new Scanner(System.in);

		do{
			try{
				//Todo: validate();
				commandoService.commandoParser(scanner.nextLine());
				commandoService.checkIfCommandoExists(commandos);
				String commando = commandoService.getCommando();
				commandos.get(commando).execute(commandoService.getParameters());
				System.out.println(nextCommand);
			} catch(Exception ex){
				System.out.println(ex.getMessage());
				System.out.println(nextCommand);
			}
		} while(true);
	}
}
