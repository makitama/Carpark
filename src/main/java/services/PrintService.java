package main.java.services;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PrintService {

	public PrintService(String ausgabe) {
		printToConsole(ausgabe);
	}

	public PrintService() {
	}

	public void printErrorMessage(String ausgabe) {
		System.out.println(ausgabe);
	}

	public void printFormattedDescription(String command, String description, String parameters) {
		System.out.printf("%-32s|%-64s|%-32s\n", command, " " + description, " " + parameters);
	}

	public void printSuccessMessage(String ausgabe) {
		System.out.println(ausgabe + " erfolgreich");
	}

	private void printToConsole(String ausgabe) {
		System.out.println(ausgabe);
	}

	public void printToFile(String file, String ausgabe) throws IOException {
		File printFile = new File(file);
		if (!printFile.exists()) {
			printFile.createNewFile();
		}
		if (printFile.isFile()) {
			try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(printFile, true))) {
				bufferedWriter.write(ausgabe);
				bufferedWriter.newLine();
			} catch (IOException e) {
				printErrorMessage("Ein Fehler trat auf: " + e);
			}
		} else {
			printErrorMessage("Bitte geben Sie einen Dateipfad inklusive Dateinamen an!");
		}
	}

	public String getActualMethodName() {
		int methodenebene = 2;
		StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[methodenebene];
		return stackTraceElement.getMethodName();
	}
}
