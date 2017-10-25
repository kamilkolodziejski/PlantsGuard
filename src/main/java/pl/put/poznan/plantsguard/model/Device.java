package pl.put.poznan.plantsguard.model;

import java.util.ArrayList;

public class Device {
	
	private final String deviceNumber;
	private Configuration configuration;
	private Measure lastMeasure;
	private DeviceState lastState;
		
	public Device(String deviceNumber) {
		super();
		this.deviceNumber = deviceNumber;
	}
	public Configuration getConfiguration() {
		return configuration;
	}
	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}
	public Measure getLastMeasure() {
		return lastMeasure;
	}
	public void setLastMeasure(Measure lastMeasure) {
		this.lastMeasure = lastMeasure;
	}
	public DeviceState getLastState() {
		return lastState;
	}
	public void setLastState(DeviceState lastState) {
		this.lastState = lastState;
	}
	public String getDeviceNumber() {
		return deviceNumber;
	}

	
}
