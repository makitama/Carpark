package services.Output;

public class PrintToConsoleService extends OutputService {

	public PrintToConsoleService(String ausgabe) {
		printToConsole(ausgabe);
	}

	public PrintToConsoleService() {
	}

	public void printErrorMessage(String ausgabe) {
		System.err.println(ausgabe);
	}

	public void printSuccessMessage(String ausgabe) {
		printToConsole(ausgabe + " erfolgreich");
	}

	public void printToConsole(String ausgabe) {
		System.out.println(ausgabe);
	}

	public void printFormattedDescription(String command, String description, String parameters) {
		System.out.printf("%-32s|%-100s|%-32s\n", command, " " + description, " " + parameters);
	}


	public void print(String ausgabe) {
		System.out.println(ausgabe);
	}

}
