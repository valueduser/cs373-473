package com.project1.dal;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper {
	
	public static Connection getConnection() {
 
		Connection connection = null;
 
		try {
			// create a database connection
	        connection = DriverManager.getConnection("jdbc:sqlite://127.0.0.1", "root", "root");
	        Statement statement = connection.createStatement();
	        statement.setQueryTimeout(30);  // set timeout to 30 sec.
 
		} catch (SQLException e) {
 
			System.out.println("DBHelper: Connection Failed! Check output console");
			e.printStackTrace();
			return null;
 
		}
 
		if (connection != null) {
			System.out.println("DBHelper: You have a database connection!");
		} else {
			System.out.println("DBHelper: Failed to make connection!");
		}
		
		return connection;
	}
}
