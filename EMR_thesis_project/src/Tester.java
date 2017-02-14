import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import emr.database.beans.DoctorBean;
import emr.database.beans.PersonBean;
import emr.database.beans.Session;
import emr.database.tableManagers.DoctorsTable;
import emr.database.tableManagers.PersonsTable;
import emr.database.tableManagers.SessionsTable;
import emr.database.util.DbUtility;
import emr.services.PersonService;
import emr.util.Constants;


public class Tester {

	public static void main(String[] args) throws SQLException {	
		
		PersonService newService = new PersonService();
		//System.out.println(foo.getSession_string());
		
		PersonBean np = new PersonBean();
		np.setName("Bal chal");
		np.setNat_id_no("balchalami");
		np.setPassword("123456");
		
		System.out.println(PersonsTable.insert_new_person(np));
	}

}
