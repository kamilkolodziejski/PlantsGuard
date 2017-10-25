package pl.put.poznan.plantsguard;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {

	    public static boolean isUserLoggedIn(){
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        if(null != authentication){
	            return (authentication.isAuthenticated() && !(authentication instanceof AnonymousAuthenticationToken));
	        }else{
	            return false;
	        }
	    }
}
