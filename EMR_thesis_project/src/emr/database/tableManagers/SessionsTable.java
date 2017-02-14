package emr.database.tableManagers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import emr.database.beans.Session;
import emr.database.util.ConnectionManager;
import emr.database.util.DbUtility;
import emr.util.Constants;

public class SessionsTable {

	private static Connection db_conn = ConnectionManager.getInstance().getConnection();
	
	private static boolean validate_user(int user_id, String password) throws SQLException {
		String sql = "Select person_id from EMR_PERSON where person_id = ? and password = ?";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = db_conn.prepareStatement(sql);
			stmt.setInt(1, user_id);
			stmt.setString(2, password);
						
			rs = stmt.executeQuery();
			
			return rs.next();
			
		} catch (SQLException e) {
			DbUtility.processException(e);
		} finally {				
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
		}
		
		return false;
	}
	
	public static Session create_session(int user_id, String password) throws SQLException {
		
		if(validate_user(user_id, password)) {
			String session_string = DbUtility.getRandomString(10);
			
			String sql = "Insert into"
					+ " EMR_SESSION (session_string, user_id, remember_me)" 
					+ "	values (?, ?, ?)";
			PreparedStatement stmt = null;
			Statement stmt2 = null;
			ResultSet rs = null;
			
			try {
				stmt = db_conn.prepareStatement(sql);
				
				stmt.setString(1, session_string);
				stmt.setInt(2, user_id);
				stmt.setInt(3, 0);
				
				stmt.executeUpdate();
				
				stmt2 = db_conn.createStatement();
				rs = stmt2.executeQuery("select EMR_SEQ_SESSION_ID.currval from dual");
				rs.next();
				
				Session new_session = new Session();
				
				new_session.setSession_id(rs.getInt(1));
				new_session.setSession_string(session_string);
				new_session.setUser_id(user_id);
				new_session.setRemember_me(0);
				
				return new_session;
				
			} catch (SQLException e) {
				DbUtility.processException(e);
			} finally {				
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
			}
			
		}
		
		return null;
	}
	
	public static int check_session(Session temp) throws SQLException {
		String sql = "Select session_string from EMR_SESSION where session_id = ?";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = db_conn.prepareStatement(sql);
			stmt.setInt(1, temp.getSession_id());
						
			rs = stmt.executeQuery();
			if(rs.next() && temp.getSession_string().equals(rs.getString("session_string")))
			return Constants.sessionFound;
			
		} catch (SQLException e) {
			DbUtility.processException(e);
		} finally {				
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
		}
		
		return Constants.sessionNotFound;
	}
	
	public static Session get_session_by_id(int session_id) throws SQLException {
		String sql = "Select * from EMR_SESSION where session_id = ?";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = db_conn.prepareStatement(sql);
			stmt.setInt(1, session_id);
						
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				Session newSession = new Session();
				newSession.setSession_id(rs.getInt("session_id"));
				newSession.setSession_string(rs.getString("session_string"));
				newSession.setUser_id(rs.getInt("user_id"));
				newSession.setRemember_me(rs.getInt("remember_me"));
				
				return newSession;
			}
			
		} catch (SQLException e) {
			DbUtility.processException(e);
		} finally {				
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
		}
		
		return null;
	}
	
	public static int delete_session(Session temp) throws SQLException {
		String sql = "delete from EMR_SESSION where session_id = ? and session_string = ?";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = db_conn.prepareStatement(sql);
			stmt.setInt(1, temp.getSession_id());
			stmt.setString(2, temp.getSession_string());
						
			int affected = stmt.executeUpdate();
			
			if (affected==1) return Constants.success;
			
		} catch (SQLException e) {
			DbUtility.processException(e);
		} finally {				
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
		}
		
		return Constants.error;
	}
	
	
}
