package emr.services;

import java.sql.SQLException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import emr.database.beans.PersonBean;
import emr.database.beans.Session;
import emr.database.tableManagers.PersonsTable;
import emr.database.tableManagers.SessionsTable;
import emr.util.Constants;

@WebService(name="emrPerson", portName="emrPersonServicePort", serviceName="emrPersonService",
			targetNamespace="http://person.services.emr")
public class PersonService{
	
	@WebMethod
	@WebResult(name="created_session")
	public Session createSession(@WebParam(name="user_id") int user_id, @WebParam(name="password") String password) {
		try {
			return SessionsTable.create_session(user_id, password);
		} catch (SQLException e) {
			return null;
		}
	}
	
	@WebMethod
	@WebResult(name="result")
	public int checkSession(@WebParam(name="target") Session target) {
		try {
			return SessionsTable.check_session(target);
		} catch (SQLException e) {
			return Constants.databaseError;
		}
	}
	
	@WebMethod
	@WebResult(name="result")
	public Session getSessionById(@WebParam(name="session_id") int session_id) {
		try {
			return SessionsTable.get_session_by_id(session_id);
		} catch (SQLException e) {
			return null;
		}
	}
	
	@WebMethod
	@WebResult(name="result")
	public int deleteSession(@WebParam(name="target") Session target) {
		try {
			return SessionsTable.delete_session(target);
		} catch (SQLException e) {
			return Constants.databaseError;
		}
	}
	
	@WebMethod
	@WebResult(name="result")
	public int insertNewPerson(@WebParam(name="new_person") PersonBean new_person) {
		try {
			return PersonsTable.insert_new_person(new_person);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Constants.databaseError;
		}
	}
	
	@WebMethod
	@WebResult(name="result")
	public int updatePerson(@WebParam(name="person") PersonBean person, @WebParam(name="session") Session temp) {
		try {
			return PersonsTable.update_person(person, temp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Constants.databaseError; 
		}
	}
		
	@WebMethod
	@WebResult(name="result")
	public PersonBean getPersonById(@WebParam(name="person_id") int person_id) {
		try {
			return PersonsTable.get_person_by_id(person_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
}
