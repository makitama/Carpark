package services.Output;

import commandos.commandos.Factories.DriveInDriveOutCommandoParamsFactory;
import commandos.commandos.Factories.ParkingSpotCommandosParamsFactory;

import java.sql.*;

public class DatabaseService extends OutputService {

	private final int UNPARKED = 0;
	private final int PARKED = 1;
	private String url;
	private String user;
	private String password;
	private PrintToConsoleService printToConsoleService;

	public DatabaseService() {
		url = "jdbc:mysql://localhost:3306/carpark";
		user = "root";
		password = "";
		printToConsoleService = new PrintToConsoleService();
	}

	public void clearParkingSpotTable() {
		try (Connection connection = DriverManager.getConnection(url, user, password)) {
			String query = "SELECT * FROM parkingspot";
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery(query);
			if (resultSet.next()) {
				query = "DELETE FROM parkingspot";
				stmt.execute(query);
				query = "ALTER TABLE parkingspot AUTO_INCREMENT = 1";
				stmt.execute(query);
			}
			stmt.close();
		} catch (SQLException ex) {
			printToConsoleService.printErrorMessage(ex.getMessage());
		}
	}

	public void putParkingSpotsInDatabase(int floorNr, int parkingSpotNr, String type) {
		try (Connection connection = DriverManager.getConnection(url, user, password)) {
			String query = "INSERT INTO parkingspot (floorNr, parkingSpotNr, type) VALUES ('" + floorNr + "', '" + parkingSpotNr + "', '" + type +
				  "')";
			Statement stmt = connection.createStatement();
			stmt.execute(query);
			stmt.close();
		} catch (SQLException ex) {
			printToConsoleService.printErrorMessage(ex.getMessage());
		}
	}

	public void saveToDatabase(DriveInDriveOutCommandoParamsFactory paramsFactory) {
		try (Connection connection = DriverManager.getConnection(url, user, password)) {
			String values = "";
			String columns = "";
			if (paramsFactory.getType().equalsIgnoreCase("car")) {
				values = paramsFactory.getManufacturer() + "', '" + paramsFactory.getHeight();
				columns = "brand, height";
			} else if (paramsFactory.getType().equalsIgnoreCase("motorcycle")) {
				values = paramsFactory.getMtype();
				columns = "m_type";
			} else {
				//todo error
			}
			String query =
				  "INSERT INTO vehicles (v_type, color, licenseplate, " + columns + ", parked) " +
						"VALUES ('" + paramsFactory.getType() + "', '" + paramsFactory.getColor() + "', '"
						+ paramsFactory.getLicense_plate() + "', '" + values + "', " + UNPARKED + ")";

			Statement stmt = connection.createStatement();
			stmt.execute(query);
			stmt.close();
		} catch (SQLException ex) {
			printToConsoleService.printErrorMessage(ex.getMessage());
		}
	}

	public void parkInDatabase(ParkingSpotCommandosParamsFactory paramsFactory) {
		try (Connection connection = DriverManager.getConnection(url, user, password)) {
			String query = "UPDATE vehicles SET parked =" + PARKED + " WHERE licenseplate = '" + paramsFactory.getLicense_plate() + "'";
			Statement stmt = connection.createStatement();
			stmt.execute(query);
			int parkingSpot_id = getDatabaseParkingSpotId(paramsFactory.getParking_spot_id(),
				  paramsFactory.getFloorNr());
			int vehicle_id = getDatabaseVehicleId(paramsFactory.getLicense_plate());
			query = "INSERT INTO parkedvehicles (parkingSpotId, vehicleId) VALUES (" + parkingSpot_id + ", " + vehicle_id + ")";
			stmt.execute(query);
			stmt.close();
		} catch (SQLException ex) {
			printToConsoleService.printErrorMessage(ex.getMessage());
		}
	}

	public void unparkInDatabase(ParkingSpotCommandosParamsFactory paramsFactory) {
		try (Connection connection = DriverManager.getConnection(url, user, password)) {
			String query = "UPDATE vehicles SET parked=" + UNPARKED + " WHERE licenseplate='" + paramsFactory.getLicense_plate() + "'";
			Statement stmt = connection.createStatement();
			stmt.execute(query);
			query = "DELETE FROM parkedvehicles " +
				  "WHERE parkingSpotId = " + getDatabaseParkingSpotId(paramsFactory.getParking_spot_id(), paramsFactory.getFloorNr());
			stmt.execute(query);
			stmt.close();
		} catch (SQLException ex) {
			printToConsoleService.printErrorMessage(ex.getMessage());
		}
	}

	public void deleteFromDatabase(String licenseplate) {
		try (Connection connection = DriverManager.getConnection(url, user, password)) {
			String query = "DELETE FROM vehicles WHERE licenseplate='" + licenseplate + "'";
			Statement stmt = connection.createStatement();
			stmt.execute(query);
			stmt.close();
		} catch (SQLException ex) {
			printToConsoleService.printErrorMessage(ex.getMessage());
		}
	}

	private int getDatabaseVehicleId(String licenseplate) {
		try (Connection connection = DriverManager.getConnection(url, user, password)) {
			String query = "SELECT id FROM vehicles WHERE licenseplate = '" + licenseplate + "'";
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery(query);
			if (resultSet.next()) {
				return resultSet.getInt(1);
			}
		} catch (SQLException ex) {
			printToConsoleService.printErrorMessage(ex.getMessage());
		}
		return 0;
	}

	private int getDatabaseParkingSpotId(int parkingSpotNr, int floorNr) {
		int parkingSpotId = 0;
		try (Connection connection = DriverManager.getConnection(url, user, password)) {
			String query = "SELECT id FROM parkingspot WHERE parkingSpotNr = '" + parkingSpotNr + "' AND floorNr = '" + floorNr + "'";
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery(query);
			if (resultSet.next()) {
				parkingSpotId = resultSet.getInt(1);
			}
			stmt.close();
			resultSet.close();
		} catch (SQLException ex) {
			printToConsoleService.printErrorMessage(ex.getMessage());
		}
		return parkingSpotId;
	}
}
