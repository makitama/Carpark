import java.io.IOException;

public class CarparkMain {
	public static void main(String[] args) throws IOException {
		ReadConfigFile properties = new ReadConfigFile();
		Carpark carpark = new Carpark(properties.getPropertyValues());

	}
}
