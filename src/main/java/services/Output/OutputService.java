package services.Output;

import java.io.IOException;

public abstract class OutputService {

	public String getActualClassName() {
		int methodenebene = 2;
		StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[methodenebene];
		String[] className = stackTraceElement.getClassName().split("\\.");
		return className[className.length - 1];
	}

	public void print(String output) {
	}

	public void print(String file, String output) throws IOException {
	}

	public void printSuccessMessage(String output) {
	}


	public void printToConsole(String output) {
	}
}
