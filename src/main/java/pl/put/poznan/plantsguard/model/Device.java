package pl.put.poznan.plantsguard.model;

import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;

public class Device {
	
	private Integer id;
	private String number;	
	private String name;
	private Configuration configuration;
	private DeviceState lastState;
	
	public Device() {}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Configuration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}

	public DeviceState getLastState() {
		return lastState;
	}

	public void setLastState(DeviceState lastState) {
		this.lastState = lastState;
	}
	
	public DeviceHeader getHeader() {
		DeviceHeader header = new DeviceHeader();
		DecimalFormat df = new DecimalFormat("#.00");
		header.setDeviceId(this.id);
		header.setDeviceName(this.name);
		header.setDeviceNumber(this.number);
		header.setLastBatteryLevel(df.format(this.getLastState().getLastBatteryLevel()));
		header.setLastIrrigate(this.lastState.getLastIrrigateDateTime().format(DateTimeFormatter.ofPattern("dd-MM-uuuu HH:mm")).toString());
		header.setLastMeasure(this.lastState.getLastMeasureDateTime().format(DateTimeFormatter.ofPattern("dd-MM-uuuu HH:mm")).toString());
		return header;
	}

}
