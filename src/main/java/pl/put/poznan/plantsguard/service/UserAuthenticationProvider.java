package pl.put.poznan.plantsguard.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class UserAuthenticationProvider implements AuthenticationProvider {

//	@Autowired
//	private UserService userService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
//        if (userService.authenticate(name, password)) {
        if(password.equals(name)) {
//        	UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(name,password);
//        	return token;
            // use the credentials
            // and authenticate against the third-party system
//        	ArrayList<GrantedAuthority> grants = new ArrayList<>();
//        	grants.add(new SimpleGrantedAuthority("Admin"));
            return new UsernamePasswordAuthenticationToken(
              name, password, new ArrayList<>());
        } else {
            return null;
        }
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
