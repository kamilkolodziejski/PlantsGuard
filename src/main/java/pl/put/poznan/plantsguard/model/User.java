package pl.put.poznan.plantsguard.model;

public class User {

	private String username;
	private String password;
	private boolean valid=false;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
	public boolean validate() {
		if(this.valid=(username.compareTo(password)==0?true:false))
			return true;
		else
			return false;
	}
}
