package pl.put.poznan.plantsguard.model;

import java.time.LocalDateTime;

public class DeviceState {
	
	private Float accountAmount;
	private Float batteryState;
	private LocalDateTime lastReport;
	private LocalDateTime lastWaterWarn;
	
	public Float getAccountAmount() {
		return accountAmount;
	}
	public void setAccountAmount(Float accountAmount) {
		this.accountAmount = accountAmount;
	}
	public Float getBatteryState() {
		return batteryState;
	}
	public void setBatteryState(Float batteryState) {
		this.batteryState = batteryState;
	}
	public LocalDateTime getLastReport() {
		return lastReport;
	}
	public void setLastReport(LocalDateTime lastReport) {
		this.lastReport = lastReport;
	}
	public LocalDateTime getLastWaterWarn() {
		return lastWaterWarn;
	}
	public void setLastWaterWarn(LocalDateTime lastWaterWarn) {
		this.lastWaterWarn = lastWaterWarn;
	}
}
