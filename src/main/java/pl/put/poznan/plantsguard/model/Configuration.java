package pl.put.poznan.plantsguard.model;

import java.util.ArrayList;
import java.util.List;

public class Configuration {
	
	//private final String deviceNumber;
	private Integer measureInterval;
	private Integer ordersInterval;
	private String notifyNumber;
	private List<String> authorizedNumbers;
	
	public Configuration() {
		authorizedNumbers = new ArrayList<String>();
	}

	public Integer getMeasureInterval() {
		return measureInterval;
	}

	public void setMeasureInterval(Integer measureInterval) {
		this.measureInterval = measureInterval;
	}

	public Integer getOrdersInterval() {
		return ordersInterval;
	}

	public void setOrdersInterval(Integer ordersInterval) {
		this.ordersInterval = ordersInterval;
	}

	public String getNotifyNumber() {
		return notifyNumber;
	}

	public void setNotifyNumber(String notifyNumber) {
		this.notifyNumber = notifyNumber;
	}

	public List<String> getAuthorizedNumbers() {
		return authorizedNumbers;
	}

	public void setAuthorizedNumbers(List<String> authorizedNumbers) {
		this.authorizedNumbers = authorizedNumbers;
	}
	
	
}
