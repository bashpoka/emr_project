package emr.database.beans;

public class Session {
	private int session_id;
	private String session_string;
	private int user_id;
	private int remember_me;
	
	public int getSession_id() {
		return session_id;
	}
	public void setSession_id(int session_id) {
		this.session_id = session_id;
	}
	public String getSession_string() {
		return session_string;
	}
	public void setSession_string(String session_string) {
		this.session_string = session_string;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getRemember_me() {
		return remember_me;
	}
	public void setRemember_me(int remember_me) {
		this.remember_me = remember_me;
	}

	
	
}
