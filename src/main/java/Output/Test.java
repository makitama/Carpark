package Output;

import java.sql.*;

public class Test {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/carpark";
		String user = "root";
		String password = "";

		try (Connection connection = DriverManager.getConnection(url, user, password)) {
			System.out.println("Verbindung erfolgreich");


			//in Datenbank schreiben:
			String query = "INSERT INTO vehicles (v_type, color, licenseplate, brand, height, parked) VALUES('Car', 'blue', 'KA-AB-3456', 'BMW', '2.05', 1)";
			Statement stmt = stmt = connection.createStatement();
			stmt.execute(query);

			//ausgeben
			query = "SELECT * FROM vehicles";

			ResultSet resultSet = stmt.executeQuery(query);
			int columns = resultSet.getMetaData().getColumnCount();
			for (int i = 1; i <= columns; i++) {
				System.out.printf("%-15s|", resultSet.getMetaData().getColumnLabel(i));
			}
			while (resultSet.next()) {
				System.out.println("\n---------------------------------------------------------");
				for (int i = 1; i <= columns; i++) {
					System.out.printf("%-15s|", resultSet.getString(i));
				}
			}

			resultSet.close();
			stmt.close();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}
}
