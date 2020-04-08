package services.Output;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PrintToFileService extends OutputService {

	PrintToConsoleService printToConsoleService = new PrintToConsoleService();

	@Override
	public void print(String file, String output) throws IOException {
		File printFile = new File(file);
		if (!printFile.exists()) {
			printFile.createNewFile();
		}
		if (printFile.isFile()) {
			try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(printFile, true))) {
				bufferedWriter.write(output);
				bufferedWriter.newLine();
			} catch (IOException e) {
				printToConsoleService.printErrorMessage("Ein Fehler trat auf: " + e);
			}
		} else {
			printToConsoleService.printErrorMessage("Bitte geben Sie einen Dateipfad inklusive Dateinamen an!");
		}
	}

}
