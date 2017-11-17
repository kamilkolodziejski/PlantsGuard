package pl.put.poznan.plantsguard.service;

import java.util.ArrayList;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import pl.put.poznan.plantsguard.model.Configuration;

@Component
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
			add("51024123323");
			add("66666666666");
		}});
		config.setMeasureInterval(15);
		config.setOrdersInterval(50);
		return config;
	}
	
}
