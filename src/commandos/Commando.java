package commandos;

import java.util.List;

public interface Commando {

	void execute(List<String> parameters);

	String getDescription();

	//TODO fill in all commandos!
	String getParameterList();
}
