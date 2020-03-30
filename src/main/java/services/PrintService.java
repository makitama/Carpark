package main.java.services;

public class PrintService {

	public PrintService(String ausgabe) {
		printToConsole(ausgabe);
	}

	public PrintService() {
	}

	private void printToConsole(String ausgabe) {
		System.out.println(ausgabe);
	}

	public void printSuccessMessage(String ausgabe) {
		System.out.println(ausgabe + " erfolgreich");
	}

	public void printFormattedDescription(String command, String description) {
		System.out.printf("%-32s|%-32s\n", command, " " + description);
	}

	public String getActualMethodName() {
		int methodenebene = 2;
		StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[methodenebene];
		return stackTraceElement.getMethodName();
	}
}
