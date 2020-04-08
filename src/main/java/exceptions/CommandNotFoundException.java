package exceptions;

public class CommandNotFoundException extends Exception {

	public CommandNotFoundException(String commando) {
		super("Das Commando " + commando + " existiert nicht. Bitte versuchen Sie es erneut");
	}

	public CommandNotFoundException() {

	}


}
