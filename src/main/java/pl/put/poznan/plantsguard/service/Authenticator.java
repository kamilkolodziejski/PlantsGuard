package pl.put.poznan.plantsguard.service;

public class Authenticator implements IAuthenticate {

	@Override
	public boolean authenticate(String login, String password) {
		if(login.equals("user") && password.equals("test"))
			return true;
		if(login.equals(password))
			return true;
		else
			return false;
	}

}
