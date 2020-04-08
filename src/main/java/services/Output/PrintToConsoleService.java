package services.Output;

public class PrintToConsoleService extends OutputService {

	public PrintToConsoleService(String output) {
		printToConsole(output);
	}

	public PrintToConsoleService() {
	}

	public void printErrorMessage(String output) {
		System.err.println(output);
	}

	public void printSuccessMessage(String output) {
		printToConsole(output + " erfolgreich");
	}

	public void printToConsole(String output) {
		System.out.println(output);
	}

	public void printFormattedDescription(String command, String description, String parameters) {
		System.out.printf("%-32s|%-100s|%-32s\n", command, " " + description, " " + parameters);
	}


	public void print(String output) {
		System.out.println(output);
	}

}
