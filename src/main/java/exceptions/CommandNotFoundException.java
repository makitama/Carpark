package exceptions;

public class CommandNotFoundException extends Exception {

	public CommandNotFoundException(String commando) {
		super("Das Kommando " + commando + " existiert nicht. Bitte versuchen Sie es erneut");
	}

	public CommandNotFoundException() {
		super("Das eingegebene Kommando ist fehlerhaft");
	}


}
