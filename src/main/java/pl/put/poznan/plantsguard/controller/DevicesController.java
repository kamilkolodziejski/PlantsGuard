package pl.put.poznan.plantsguard.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.put.poznan.plantsguard.model.Configuration;
import pl.put.poznan.plantsguard.model.Device;
import pl.put.poznan.plantsguard.model.User;
import pl.put.poznan.plantsguard.service.DeviceManager;

@Controller
public class DevicesController {
	
	@Autowired
	private DeviceManager deviceManager;
	
//	@ModelAttribute
//	public void addDevicesList(Model model) {
//		if(!model.containsAttribute("devices"))
//			model.addAttribute("devices", deviceManager.getDeviceHeaders());
//				
//	}
	
	@GetMapping("/devices")
	public String listDevices(Model model) {
		model.addAttribute("devices", deviceManager.getDeviceHeaders());
		return "devices";
	}
	
	@GetMapping("/device/{deviceId}")
	public String getDevice(@PathVariable Integer deviceId, Model model) {
		Device device = deviceManager.getDeviceById(deviceId);
//		Configuration configuration = null;
//		try {
//			configuration = device.getDeviceConfiguration();
//		} catch(NullPointerException e) {throw new HttpClientErrorException(HttpStatus.NOT_FOUND);} 
//		model.addAttribute("configuration", configuration);
//		model.addAttribute("deviceId", deviceId);
		model.addAttribute("device", device);
		model.addAttribute("orgDevice", device);
		return "device";
	}
	
	@PostMapping("/device/{deviceId}")
	public String saveDeviceConfig(//@ModelAttribute(name="configuration") Configuration config, 
			@ModelAttribute(name="device") Device device,
			@PathVariable Integer deviceId, 
			Model model) {
		//Device device = deviceManager.getDeviceById(deviceId);
		//device.setDeviceConfiguration(config);
		Device tmpDevice = deviceManager.getDeviceById(deviceId);
		tmpDevice.setName(device.getName());
		tmpDevice.setConfiguration(device.getConfiguration());		
		deviceManager.updateDeviceById(deviceId, tmpDevice);
		model.addAttribute("msg","Ustawienia zapisano");
		return "redirect:/devices";
		
	}
}
