package pl.put.poznan.plantsguard.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import pl.put.poznan.plantsguard.model.Configuration;

@Service
public class ConfigurationService {

	private static Configuration configuration;
	
	public ConfigurationService() {
		configuration = getFromCode();
	}
	
	public static Configuration getConfiguration() {
		return configuration;
	}

	public static void setConfiguration(Configuration configuration) {
		ConfigurationService.configuration = configuration;
	}

	public static void saveConfiguration(Configuration config) {
		configuration.setAuthorizedNumbers(config.getAuthorizedNumbers());
		configuration.setMeasureInterval(config.getMeasureInterval());
		configuration.setOrdersInterval(config.getOrdersInterval());
	}

	private Configuration getFromCode() {
		Configuration config = new Configuration();
		config.setAuthorizedNumbers(new ArrayList<String>() {{ 
			add("510243323");
			add("666666666");
		}});
		config.setMeasureInterval(15);
		config.setOrdersInterval(50);
		return config;
	}
	
}
