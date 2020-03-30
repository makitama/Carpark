package main.java.commandos;

import java.util.Map;

public interface Commando {

	void execute(Map<String, String> parameters);

	String getDescription();

	//TODO fill in all main.java.commandos!
	String getParameterList();
}
