package carpark;

import commandos.Commando;
import commandos.CommandoList;
import services.CommandoService;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class CarparkMain {

	private static final String nextCommand = "Und dann?";

	public static void main(String[] args) throws IOException {
		//todo refactor name of class.
		Initialize initialize = new Initialize();
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
				System.out.println(nextCommand);
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
				System.out.println(nextCommand);
			}
		} while(true);
	}
}
