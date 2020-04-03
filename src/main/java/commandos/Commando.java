package commandos;

import java.util.Map;

public interface Commando {

	void execute(Map<String, String> parameters);

	String getDescription();

	String getParameterList();
}
