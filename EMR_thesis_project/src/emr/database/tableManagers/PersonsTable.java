package emr.database.tableManagers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import emr.database.beans.PersonBean;
import emr.database.beans.Session;
import emr.database.util.ConnectionManager;
import emr.database.util.DbUtility;
import emr.util.Constants;


public class PersonsTable {
	private static Connection db_conn = ConnectionManager.getInstance().getConnection();
	private static int last_inserted_person_id;
	

	public static int getLast_inserted_person_id() {
		return last_inserted_person_id;
	}

	private static boolean is_unique_person(String nat_id_no) throws SQLException {
		
		String sql = "Select name from EMR_PERSON where nat_id_no = ?";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = db_conn.prepareStatement(sql);
			stmt.setString(1, nat_id_no);
						
			rs = stmt.executeQuery();
			
			return !rs.next();
			
		} catch (SQLException e) {
			DbUtility.processException(e);
		} finally {				
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
		}
		
		return false;
		
	}
	
	private static PersonBean process_result_set_to_person_bean(ResultSet rs) throws SQLException {
		PersonBean temp = new PersonBean();
		
		try {
			temp.setPerson_id(rs.getInt("person_id"));
			temp.setPassword(rs.getString("password"));
			temp.setName(rs.getString("name"));
			temp.setSex(rs.getInt("sex"));
			temp.setPerson_type(rs.getInt("person_type"));
			temp.setBirth_date(rs.getString("birth_date"));
			temp.setCurr_add(rs.getString("curr_add"));
			temp.setPmnt_add(rs.getString("pmnt_add"));
			temp.setFather_name(rs.getString("father_name"));
			temp.setMother_name(rs.getString("mother_name"));
			temp.setMarital_stat(rs.getInt("marital_stat"));
			temp.setSpouse_name(rs.getString("spouse_name"));
			temp.setPhone_no(rs.getString("phone_no"));
			temp.setEmail(rs.getString("email"));
			temp.setNat_id_no(rs.getString("nat_id_no"));

		} catch (SQLException e) {
			DbUtility.processException(e);
		} finally {				
			if(rs!=null) rs.close();
		}
		return temp;
	}
	
	public static String person_bean_to_string(PersonBean db) {
		StringBuffer bf = new StringBuffer();
		bf.append("Person id: " + db.getPerson_id() + ", ");
		return bf.toString();
	}

	
	public static List<PersonBean> get_all_persons() throws SQLException {
		List<PersonBean> all_persons = new ArrayList<PersonBean>();
		
		String sql = "Select * from EMR_PERSON";
		Statement stmt = null;
		ResultSet rs = null;
	
		try {
			stmt = db_conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				all_persons.add(process_result_set_to_person_bean(rs));
			}
			
		} catch (SQLException e) {
			DbUtility.processException(e);
		} finally {				
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
		}
		
		return  all_persons;
	}
	
	public static PersonBean get_person_by_id(int person_id) throws SQLException {
		PersonBean target_person = new PersonBean();
		
		String sql = "Select * from EMR_PERSON where person_id = ?";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = db_conn.prepareStatement(sql);
			stmt.setInt(1, person_id);
			
			rs = stmt.executeQuery();
			rs.next();
			target_person = process_result_set_to_person_bean(rs);
			
		} catch (SQLException e) {
			DbUtility.processException(e);
		} finally {				
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
		}
		
		return target_person;
	}
	
	public static String get_person_name_by_id(int person_id) throws SQLException {
		String person_name = null;
		
		String sql = "Select name from EMR_PERSON where person_id = ?";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = db_conn.prepareStatement(sql);
			stmt.setInt(1, person_id);
						
			rs = stmt.executeQuery();
			rs.next();
			person_name = rs.getString("name");
			
		} catch (SQLException e) {
			DbUtility.processException(e);
		} finally {				
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
		}
		
		return person_name;
	}
	
	//select EMR_SEQ_PERSON_ID.currval from dual
	public static int insert_new_person(PersonBean person) throws SQLException {
		
		if(!is_unique_person(person.getNat_id_no())) {			
			return Constants.errorDuplicateUser;
		}
			
		String sql = "Insert into"
				+ " EMR_PERSON (PASSWORD, NAME, SEX, PERSON_TYPE, BIRTH_DATE, CURR_ADD, PMNT_ADD, FATHER_NAME, MOTHER_NAME, "
				+ " MARITAL_STAT,SPOUSE_NAME,PHONE_NO,EMAIL, NAT_ID_NO)" 
				+ "	values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = null;
		Statement stmt2 = null;
		ResultSet rs = null;
		
		try {
			stmt = db_conn.prepareStatement(sql);
			
			stmt.setString(1, person.getPassword());
			stmt.setString(2, person.getName());
			stmt.setInt(3, person.getSex());
			stmt.setInt(4, person.getPerson_type());
			stmt.setString(5, person.getBirth_date());
			stmt.setString(6, person.getCurr_add());
			stmt.setString(7, person.getPmnt_add());
			stmt.setString(8, person.getFather_name());
			stmt.setString(9, person.getMother_name());
			stmt.setInt(10, person.getMarital_stat());
			stmt.setString(11, person.getSpouse_name());
			stmt.setString(12, person.getPhone_no());
			stmt.setString(13, person.getEmail());
			stmt.setString(14, person.getNat_id_no());
			
			stmt.executeUpdate();
			
			//if (affected==1) result = true;
			
			stmt2 = db_conn.createStatement();
			rs = stmt2.executeQuery("select EMR_SEQ_PERSON_ID.currval from dual");
			rs.next();
		
			last_inserted_person_id = rs.getInt(1);
			
		} catch (SQLException e) {
			DbUtility.processException(e);
		} finally {				
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
		}
		
		return last_inserted_person_id;
	}
	
	
	public static int update_person(PersonBean person, Session temp) throws SQLException {
		
		if(SessionsTable.check_session(temp) == Constants.sessionNotFound) return Constants.sessionNotFound;
		
		String sql = "UPDATE EMR_PERSON SET"
				+ " PASSWORD = ?, NAME = ?, SEX = ?, PERSON_TYPE = ?, BIRTH_DATE = ?, CURR_ADD = ?, PMNT_ADD = ?,"
				+ " FATHER_NAME = ?, MOTHER_NAME = ?, MARITAL_STAT = ?,SPOUSE_NAME = ?,PHONE_NO = ?,EMAIL = ?, NAT_ID_NO = ?" 
				+ "	WHERE PERSON_ID = ?";
		PreparedStatement stmt = null;
				
		try {
			stmt = db_conn.prepareStatement(sql);
			
			stmt.setString(1, person.getPassword());
			stmt.setString(2, person.getName());
			stmt.setInt(3, person.getSex());
			stmt.setInt(4, person.getPerson_type());
			stmt.setString(5, person.getBirth_date());
			stmt.setString(6, person.getCurr_add());
			stmt.setString(7, person.getPmnt_add());
			stmt.setString(8, person.getFather_name());
			stmt.setString(9, person.getMother_name());
			stmt.setInt(10, person.getMarital_stat());
			stmt.setString(11, person.getSpouse_name());
			stmt.setString(12, person.getPhone_no());
			stmt.setString(13, person.getEmail());
			stmt.setString(14, person.getNat_id_no());
			stmt.setInt(15, person.getPerson_id());
			
			int affected = stmt.executeUpdate();
			
			if (affected==1) {
				return Constants.success;
			} else {
				return Constants.error;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Constants.error;
		}
	}
}
