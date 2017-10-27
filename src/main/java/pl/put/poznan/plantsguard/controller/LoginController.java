package pl.put.poznan.plantsguard.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import pl.put.poznan.plantsguard.model.User;
import utils.SecurityUtils;

@Controller
public class LoginController {
	
//	@ModelAttribute("user")
//	public User SetUpUserForm() {
//		return new User();
//	}
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/login?logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	}

	@GetMapping(value= {"/login","/"})
	public String login(Model model, String err, String logout) {
		if(SecurityUtils.isUserLoggedIn()) return "redirect:/dashboard";
		if(err!=null) model.addAttribute("error", "Błędny login lub hasło");
		if(logout!=null) model.addAttribute("logout", "Nastąpiło poprawne wylogowanie");
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute("user") User user, Model model) {
		if(user.validate()) 
			return "redirect:/dashboard";
		model.addAttribute("error", "Błędny login lub hasło");
		return "login";
	}
}
