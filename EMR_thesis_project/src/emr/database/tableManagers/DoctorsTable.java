package emr.database.tableManagers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import emr.database.beans.DoctorBean;
import emr.database.util.ConnectionManager;
import emr.database.util.DbUtility;

public class DoctorsTable {
	private static Connection db_conn = ConnectionManager.getInstance().getConnection();
	private static int last_inserted_doctor_id;

	public static int getLast_inserted_doctor_id() {
		return last_inserted_doctor_id;
	}
	
	private static List<String> process_past_hosp_id_string(String past_hosp_id_string) {
		List<String> past_hosp_ids = new ArrayList<String>();
		
		String parts[] = past_hosp_id_string.split("[,]");
		
		for(int i=0; i<parts.length; i++) {
			past_hosp_ids.add(parts[i]);
		}
		return past_hosp_ids;
	}
	
	private static DoctorBean process_result_set_to_doctor_bean(ResultSet rs) throws SQLException {
		DoctorBean temp = new DoctorBean();
		List<String> temp_s = new ArrayList<String>();
		
		try {
			temp.setDoctor_id(rs.getInt("doctor_id"));
			temp.setPerson_id(rs.getInt("person_id"));
			temp.setCurr_hosp_id(rs.getInt("curr_hosp_id"));
			temp.setPast_hosp_ids(process_past_hosp_id_string(rs.getString("past_hosp_ids")));
			temp.setDegrees(rs.getString("degrees"));
			
			if(rs.getString("expertise_1") != null) temp_s.add(rs.getString("expertise_1"));
			if(rs.getString("expertise_2") != null) temp_s.add(rs.getString("expertise_2"));
			if(rs.getString("expertise_3") != null) temp_s.add(rs.getString("expertise_3"));
			if(rs.getString("expertise_4") != null) temp_s.add(rs.getString("expertise_4"));
			if(rs.getString("expertise_5") != null) temp_s.add(rs.getString("expertise_5"));
		} catch (SQLException e) {
			DbUtility.processException(e);
		} finally {				
			if(rs!=null) rs.close();
		}
		return temp;
	}
	
	public static String doctor_bean_to_string(DoctorBean db) {
		StringBuffer bf = new StringBuffer();
		bf.append("Doctor id: " + db.getDoctor_id() + ", ");
		bf.append("Person id: " + db.getPerson_id() + ", ");
		return bf.toString();
	}
	
	public static List<DoctorBean> get_all_doctors() throws SQLException {
		List<DoctorBean> all_doctors = new ArrayList<DoctorBean>();
		
		String sql = "Select * from EMR_DOCTOR";
		Statement stmt = null;
		ResultSet rs = null;
	
		try {
			stmt = db_conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				all_doctors.add(process_result_set_to_doctor_bean(rs));
			}
			
		} catch (SQLException e) {
			DbUtility.processException(e);
		} finally {				
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
		}	
		
		return  all_doctors;
	}

	public static DoctorBean get_doctor_by_id(int doctor_id) throws SQLException {
		DoctorBean target_doctor = new DoctorBean();
		
		String sql = "Select * from EMR_DOCTOR where doctor_id = ?";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = db_conn.prepareStatement(sql);
			stmt.setInt(1, doctor_id);
			
			rs = stmt.executeQuery();
			rs.next();
			target_doctor = process_result_set_to_doctor_bean(rs);
			
		} catch (SQLException e) {
			DbUtility.processException(e);
		} finally {				
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
		}
		
		return target_doctor;
	}
	
	public static String get_doctor_name_by_doctor_id(int doctor_id) throws SQLException {
		int person_id = get_doctor_by_id(doctor_id).getPerson_id(); 
		return PersonsTable.get_person_name_by_id(person_id);
	}
	
	public static boolean insert_new_doctor(DoctorBean person, int person_id) throws SQLException {
//		if(!is_unique_person(person.getNat_id_no())) {			
//			return false;
//		}
//		
//		boolean result = false;
//		
		// String sql = "Insert into"
		// 		+ " EMR_PERSON (PASSWORD, NAME, SEX, PERSON_TYPE, BIRTH_DATE, CURR_ADD, PMNT_ADD, FATHER_NAME, MOTHER_NAME, "
		// 		+ " MARITAL_STAT,SPOUSE_NAME,PHONE_NO,EMAIL, NAT_ID_NO)" 
		// 		+ "	values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		// PreparedStatement stmt = null;
		// Statement stmt2 = null;
		// ResultSet rs = null;
//		
//		try {
//			stmt = db_conn.prepareStatement(sql);
//			
//			stmt.setString(1, person.getPassword());
//			stmt.setString(2, person.getName());
//			stmt.setInt(3, person.getSex());
//			stmt.setInt(4, person.getPerson_type());
//			stmt.setString(5, person.getBirth_date());
//			stmt.setString(6, person.getCurr_add());
//			stmt.setString(7, person.getPmnt_add());
//			stmt.setString(8, person.getFather_name());
//			stmt.setString(9, person.getMother_name());
//			stmt.setInt(10, person.getMarital_stat());
//			stmt.setString(11, person.getSpouse_name());
//			stmt.setString(12, person.getPhone_no());
//			stmt.setString(13, person.getEmail());
//			stmt.setString(14, person.getNat_id_no());
//			
//			int affected = stmt.executeUpdate();
//			
//			if (affected==1) result = true;
//			
//			stmt2 = db_conn.createStatement();
//			rs = stmt2.executeQuery("select EMR_SEQ_PERSON_ID.currval from dual");
//			rs.next();
//		
//			last_inserted_person_id = rs.getInt(1);
//			
//		} catch (SQLException e) {
//			DbUtility.processException(e);
//		} finally {				
//			if(rs!=null) rs.close();
//			if(stmt!=null) stmt.close();
//		}
//		
		return false;
	}

	public static boolean update_doctor_by_id(int doctor_id, DoctorBean doctor) throws SQLException {
		
		String sql = "UPDATE EMR_DOCTOR SET"
				+ " PERSON_ID = ?, CURR_HOSP_ID = ?, PAST_HOSP_IDS = ?, DEGREES = ?, "
				+ " EXPERTISE_1 = ?, EXPERTISE_2 = ?, EXPERTISE_3 = ?,EXPERTISE_4 = ?,EXPERTISE_5 = ?" 
				+ "	WHERE PERSON_ID = ?";
		PreparedStatement stmt = null;
		
		try {
			stmt = db_conn.prepareStatement(sql);
			
			stmt.setInt(1, doctor.getPerson_id());
			stmt.setInt(2, doctor.getCurr_hosp_id());
			stmt.setString(3, DbUtility.list_to_string(doctor.getPast_hosp_ids()));
			stmt.setString(4, doctor.getDegrees());
			stmt.setString(5, doctor.getExpertises().get(0));
			stmt.setString(6, doctor.getExpertises().get(1));
			stmt.setString(7, doctor.getExpertises().get(2));
			stmt.setString(8, doctor.getExpertises().get(3));
			stmt.setString(9, doctor.getExpertises().get(4));
			stmt.setInt(10, doctor_id);
			
			int affected = stmt.executeUpdate();
			
			if (affected==1) {
				return true;
			} else {
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	
}
