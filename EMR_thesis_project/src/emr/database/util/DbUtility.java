package emr.database.util;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

public class DbUtility {
	
	public static String getHashedPassword(String password, int length) {
		String generatedPassword = null;
		try {
		    // Create MessageDigest instance for MD5
		    MessageDigest md = MessageDigest.getInstance("MD5");
		    //Add password bytes to digest
		    md.update(password.getBytes());
		    //Get the hash's bytes 
		    byte[] bytes = md.digest();
		    //This bytes[] has bytes in decimal format;
		    //Convert it to hexadecimal format
		    StringBuilder sb = new StringBuilder();
		    
		    for(int i=0; i< bytes.length ;i++) {
		        sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
		    }
		    //Get complete hashed password in hex format
		    generatedPassword = sb.toString().substring(0, length);
		} 
		catch (NoSuchAlgorithmException e) 
		{
		    e.printStackTrace();
		}
		
		return generatedPassword;
	}
	
	public static String getHashedPassword(String password) {
		return getHashedPassword(password, 15);
	}
	
	public static void processException(SQLException e) {
		System.err.println("Error message: " + e.getMessage());
		System.err.println("Error code: " + e.getErrorCode());
		System.err.println("SQL state: " + e.getSQLState());
	}
	
	public static String list_to_string(List<String> list) {
		String listString = "";
		int i=0;
		
		for (; i<list.size()-1; i++) {
		    listString += list.get(i) + ",";
		} listString += list.get(i);
		
		return listString;
	}
	
	public static String getRandomString( int len ) {	
		   String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		   Random rnd = new Random();
		   StringBuilder sb = new StringBuilder( len );
		   for( int i = 0; i < len; i++ ) 
		      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		   return sb.toString();
	}
		
	
}
