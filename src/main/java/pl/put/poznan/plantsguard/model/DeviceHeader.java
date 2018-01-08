package pl.put.poznan.plantsguard.model;

public class DeviceHeader {

	private Integer deviceId;
	private String deviceName;
	private String deviceNumber;
	private String lastMeasure;
	private String lastBatteryLevel;
	private String lastIrrigate;
	
	public Integer getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getDeviceNumber() {
		return deviceNumber;
	}
	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}
	public String getLastMeasure() {
		return lastMeasure;
	}
	public void setLastMeasure(String lastMeasure) {
		this.lastMeasure = lastMeasure;
	}
	public String getLastBatteryLevel() {
		return lastBatteryLevel;
	}
	public void setLastBatteryLevel(String lastBatteryLevel) {
		this.lastBatteryLevel = lastBatteryLevel;
	}
	public String getLastIrrigate() {
		return lastIrrigate;
	}
	public void setLastIrrigate(String lastIrrigate) {
		this.lastIrrigate = lastIrrigate;
	}
}
