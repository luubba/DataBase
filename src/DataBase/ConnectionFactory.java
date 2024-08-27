package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/anime_store";
		String username = "root";
		String password = "3110";
		try {
			Connection connection = (Connection) DriverManager.getConnection(url, username, password);
			System.out.println(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
