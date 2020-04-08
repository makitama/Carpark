package carpark;

import commandos.Commando;
import commandos.CommandoList;
import services.CommandoService;
import services.Output.PrintToConsoleService;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class CarparkMain {

	private static final String nextCommand = "Und dann?";

	public static void main(String[] args) throws IOException {
		//todo refactor name of class.
		Initialize initialize = new Initialize();
		PrintToConsoleService printService = new PrintToConsoleService();
		CommandoList commandoList = initialize.getCommandoList();
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
				printService.print(nextCommand);
			} catch (Exception ex) {
				printService.printErrorMessage(ex.getMessage());
				printService.print(nextCommand);
			}
		} while(true);
	}
}
