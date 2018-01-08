package pl.put.poznan.plantsguard.model;

import java.time.LocalDateTime;

public class DeviceState{
	
	private LocalDateTime lastMeasureDateTime;
	private LocalDateTime lastIrrigateDateTime;
	private Double lastBatteryLevel;
	
	public DeviceState() { }
	
	public DeviceState(LocalDateTime lastMeasureDateTime, LocalDateTime lastIrrigateDateTime, Double lastBatteryLevel) {
		super();
		this.lastMeasureDateTime = lastMeasureDateTime;
		this.lastIrrigateDateTime = lastIrrigateDateTime;
		this.lastBatteryLevel = lastBatteryLevel;
	}
	
	public LocalDateTime getLastMeasureDateTime() {
		return lastMeasureDateTime;
	}
	public void setLastMeasureDateTime(LocalDateTime lastMeasureDateTime) {
		this.lastMeasureDateTime = lastMeasureDateTime;
	}
	public LocalDateTime getLastIrrigateDateTime() {
		return lastIrrigateDateTime;
	}
	public void setLastIrrigateDateTime(LocalDateTime lastIrrigateDateTime) {
		this.lastIrrigateDateTime = lastIrrigateDateTime;
	}
	public Double getLastBatteryLevel() {
		return lastBatteryLevel;
	}
	public void setLastBatteryLevel(Double lastBatteryLevel) {
		this.lastBatteryLevel = lastBatteryLevel;
	}

	

}
