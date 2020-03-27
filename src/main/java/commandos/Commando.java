package main.java.commandos;

import java.util.List;

public interface Commando {

	void execute(List<String> parameters);

	String getDescription();

	//TODO fill in all main.java.commandos!
	String getParameterList();
}
