package pl.put.poznan.plantsguard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChartsController {
	
	@GetMapping("/charts")
	public String getChart(Model model) {
		return "charts";
	}

}
