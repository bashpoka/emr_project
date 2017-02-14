package emr.database.beans;

import java.util.List;
import java.util.ArrayList;

public class DoctorBean {
	private int doctor_id;
	private int person_id;
	private int curr_hosp_id;
	private List<String> past_hosp_ids = new ArrayList<>();
	private String degrees;
	private List<String> expertises = new ArrayList<>();
	

	public int getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}
	
	public int getPerson_id() {
		return person_id;
	}
	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}
	
	
	public int getCurr_hosp_id() {
		return curr_hosp_id;
	}
	public void setCurr_hosp_id(int curr_hosp_id) {
		this.curr_hosp_id = curr_hosp_id;
	}
	
	public List<String> getPast_hosp_ids() {
		return past_hosp_ids;
	}
	public void setPast_hosp_ids(List<String> past_hosp_ids) {
		this.past_hosp_ids = past_hosp_ids;
	}
	
	public String getDegrees() {
		return degrees;
	}
	public void setDegrees(String degrees) {
		this.degrees = degrees;
	}
	
	public List<String> getExpertises() {
		return expertises;
	}
	public void setExpertises(List<String> expertises) {
		this.expertises = expertises;
	}
}
