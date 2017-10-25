package pl.put.poznan.plantsguard.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.put.poznan.plantsguard.model.Configuration;
import pl.put.poznan.plantsguard.model.User;
import pl.put.poznan.plantsguard.service.ConfigurationService;

@Controller
public class SettingsController {
	
	@ModelAttribute
	public void addAttributes(Model model) {
		if(!model.containsAttribute("configuration"))
			model.addAttribute("configuration", ConfigurationService.getConfiguration());
				
	}
	
	@GetMapping("/settings")
	public String settings() {
		ArrayList<String> list = ConfigurationService.getConfiguration().getAuthorizedNumbers();
		
		for (String phone : list) {
			System.out.println(phone);			
		}
		return "settings";
	}
	
	@PostMapping("/settings")
	public String saveConfig(@ModelAttribute(name="configuration") Configuration config, Model model) {
		int i=0;
		for (String item : config.getAuthorizedNumbers()) {
			System.out.println(++i+" - "+item);
		}
		
		ConfigurationService.setConfiguration(config);
		
		model.addAttribute("msg","Ustawienia zapisano");
		return "settings";
		
	}
}
