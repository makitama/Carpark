package commandos.commandos.Factories;

import com.mysql.cj.util.StringUtils;

import java.util.Map;

public class ListCommandoParamsFactory {

	private String file;

	public ListCommandoParamsFactory(Map<String, String> parameters) {
		this.file = parameters.get("FILE");
	}

	public String getFile() {
		return file;
	}

	public boolean isEmpty() {
		if (StringUtils.isEmptyOrWhitespaceOnly(getFile())) {
			return true;
		}
		return false;
	}
}
