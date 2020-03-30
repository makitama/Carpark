package main.java.services;

import main.java.commandos.Commando;

import java.util.HashMap;
import java.util.Map;

public class CommandoService {

	private String commando;
	private Map<String, String> parameters;

	public void commandoParser(String commando) {
		String[] splittedCommando = commando.toUpperCase().split(" ");
		parameters = new HashMap<>();
		this.commando = splittedCommando[0];
		if (splittedCommando.length > 1) {
			parameters = splitParameters(splittedCommando);
		}
	}

	public String getCommando() {
		return commando;
	}

	public Map<String, String> getParameters() {
		if (parameters.isEmpty()) {
			return new HashMap<>();
		} else {
			return parameters;
		}
	}

	public void checkIfCommandoExists(Map<String, Commando> commandos) {
		if (!commandos.containsKey(commando)) {
			//todo throw new CommandNotFoundException(commando);
		}
	}

	public Map<String, String> splitParameters(String[] parameters) {
		Map<String, String> params = new HashMap<>();
		for (int i = 1; i < parameters.length; i++) {
			String[] param = parameters[i].split("=");
			params.put(param[0], param[1]);
		}
		return params;
	}

}
