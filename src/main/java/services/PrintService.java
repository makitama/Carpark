package main.java.services;

public class PrintService {

	public PrintService(String ausgabe) {
		printToConsole(ausgabe);
	}

	private void printToConsole(String ausgabe){
		System.out.println(ausgabe);
	}
}
