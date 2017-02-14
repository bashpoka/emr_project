package emr.database.beans;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PersonBean {
	private int person_id;
	private String password;
	private String name;
	private int sex = 1;
	private int person_type = 1;
	private String birth_date = "";
	private String curr_add;
	private String pmnt_add;
	private String father_name;
	private String mother_name;
	private int marital_stat = 0;
	private String spouse_name;
	private String phone_no;
	private String email;
	private String nat_id_no;
	
	
	public int getPerson_id() {
		return person_id;
	}	
	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getPerson_type() {
		return person_type;
	}
	public void setPerson_type(int person_type) {
		this.person_type = person_type;
	}
	public String getBirth_date() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat returnFormat = new SimpleDateFormat("dd MMM yyyy");
		java.util.Date parsed;
		try {
			parsed = format.parse(birth_date);
			return returnFormat.format(parsed);
			
		} catch (ParseException e) {
			
		}
		
		return birth_date;
	}


	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}
	public String getCurr_add() {
		return curr_add;
	}
	public void setCurr_add(String curr_add) {
		this.curr_add = curr_add;
	}
	public String getPmnt_add() {
		return pmnt_add;
	}
	public void setPmnt_add(String pmnt_add) {
		this.pmnt_add = pmnt_add;
	}
	public String getFather_name() {
		return father_name;
	}
	public void setFather_name(String father_name) {
		this.father_name = father_name;
	}
	public String getMother_name() {
		return mother_name;
	}
	public void setMother_name(String mother_name) {
		this.mother_name = mother_name;
	}
	public int getMarital_stat() {
		return marital_stat;
	}
	public void setMarital_stat(int marital_stat) {
		this.marital_stat = marital_stat;
	}
	public String getSpouse_name() {
		return spouse_name;
	}
	public void setSpouse_name(String spouse_name) {
		this.spouse_name = spouse_name;
	}
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNat_id_no() {
		return nat_id_no;
	}
	public void setNat_id_no(String nat_id_no) {
		this.nat_id_no = nat_id_no;
	}
	
	
}
