package bookshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	 public static Connection getConnection() throws SQLException {
		 String url = "jdbc:postgresql://localhost:5433/BookShop"; 
	 String user = "postgres";
String password = "sidjoshi@0512";
	 return DriverManager.getConnection(url, user, password); } 
}
