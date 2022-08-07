package hachani.marwa.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
	private static Connection connection; //Ce bloc sera éxécuté une seule et unique fois 
	static{ 
		try { Class.forName("com.mysql.jdbc.Driver"); 
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_bancaire", "root", "adminadmin"); 
		System.out.println("Established connection...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); 
			} catch (SQLException e) {
				e.printStackTrace(); 
				} 
		} 
	public static Connection getConnection() { 
		return connection; 
		} 
	
}
