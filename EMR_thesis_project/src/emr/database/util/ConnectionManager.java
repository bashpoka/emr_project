package emr.database.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private static ConnectionManager instance = null; 		// creates the one and only instance of this class
	
	private final String USERNAME = "dbuser"; 				// name of the database user  
	private final String PASSWORD = "123456";			// password of the database user
	private final String CONN_STRING = 
					"jdbc:oracle:thin:@localhost"; 			// connection string for the oracle database
	
	private Connection conn = null;							// creates the one and only connection object
	
	private ConnectionManager() {}							// a private constructor method
	
	public static ConnectionManager getInstance() { 		// return the only instance of this class
		if (instance == null) {
			instance = new ConnectionManager();
		}
		return instance;
	}
	
	private boolean openConnection() {						// open the only connection
		try {
			conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			return true;
		}
		catch (SQLException e) {
			System.err.println(e);
			return false;
		}
	}
	

	public Connection getConnection() {						// return the connection object
		if (conn == null) {									
			if (openConnection()) {
				return conn;
			} else {
				return null;
			}
		}
		return conn;
	}
	
	public void close() {									// close the connection		
		try {
			conn.close();
			conn = null;
		} catch (Exception e) {
		}
	}
}
