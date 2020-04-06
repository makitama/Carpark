package Output;

public class PrintToConsoleService extends OutputService {

	public void printErrorMessage(String ausgabe) {
		System.out.println(ausgabe);
	}

	public void printSuccessMessage(String ausgabe) {
		System.out.println(ausgabe + " erfolgreich");
	}

	private void printToConsole(String ausgabe) {
		System.out.println(ausgabe);
	}

	public void printFormattedDescription(String command, String description, String parameters) {
		System.out.printf("%-32s|%-100s|%-32s\n", command, " " + description, " " + parameters);
	}

}
