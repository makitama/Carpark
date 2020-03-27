package main.java.services;

import main.java.commandos.Commando;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommandoService {

	private String commando;
	private List<String> parameters;

	public void commandoParser(String commando){
		String[] splittedCommando = commando.toUpperCase().split(" ");
		this.commando = splittedCommando[0];
		//todo überarbeiten
		parameters = new ArrayList<>();
		if(splittedCommando.length > 1){
			for(int i=1; i< splittedCommando.length; i++){
				parameters.add(splittedCommando[i]);
			}
		}
	}

	public String getCommando() {
		return commando;
	}

	public List<String> getParameters(){
		if(parameters.isEmpty()){
			return new ArrayList<>();
		}else{
			return parameters;
		}
	}

	public void checkIfCommandoExists(Map<String, Commando> commandos){
		if(!commandos.containsKey(commando)){
			throw new CommandNotFoundException(commando);
		}
	}


}
