package main.java;

import main.java.commandos.Commando;
import main.java.commandos.CommandoList;
import main.java.filehandling.ReadConfigFile;
import main.java.services.CarparkService;
import main.java.services.CommandoService;
import main.java.services.ParkingService;
import main.java.services.ParkingSpotService;

import java.io.IOException;

public class CarparkMain {
	public static void main(String[] args) throws IOException {
		ReadConfigFile properties = new ReadConfigFile();
		Carpark carpark = new Carpark(properties.getPropertyValues());

	}
}
