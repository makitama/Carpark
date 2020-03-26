package filehandling;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ReadConfigFile {

	Map<String, Integer> properties;
	private InputStream inputStream;

	public ReadConfigFile() {
		properties = new HashMap<>();
	}

	public Map<String, Integer> getPropertyValues() throws IOException {
		try {
			Properties props = new Properties();
			String propFileName = "config.properties";
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			if (inputStream != null) {
				props.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "'not found in the classpath");
			}
			properties.put("floors", Integer.parseInt(props.getProperty("floors")));
			properties.put("carParkingSpots", Integer.parseInt(props.getProperty("carParkingSpots")));
			properties.put("mcycleParkingSpots", Integer.parseInt(props.getProperty("mcycleParkingSpots")));
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return properties;
	}
}
