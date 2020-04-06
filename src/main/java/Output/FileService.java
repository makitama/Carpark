package Output;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileService extends OutputService {

	PrintToConsoleService printToConsoleService = new PrintToConsoleService();

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
				printToConsoleService.printErrorMessage("Ein Fehler trat auf: " + e);
			}
		} else {
			printToConsoleService.printErrorMessage("Bitte geben Sie einen Dateipfad inklusive Dateinamen an!");
		}
	}

}
