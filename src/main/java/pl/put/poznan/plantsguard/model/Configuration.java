package pl.put.poznan.plantsguard.model;

import java.util.ArrayList;

public class Configuration {
	
	//private final String deviceNumber;
	private Integer measureInterval;
	private Integer ordersInterval;
	private String notifyNumber;
	ArrayList<String> authorizedNumbers;
	
	public Configuration() {
		authorizedNumbers = new ArrayList<String>();
	}
	
	public int getMeasureInterval() {
		return measureInterval;
	}
	public void setMeasureInterval(int measureInterval) {
		this.measureInterval = measureInterval;
	}
	public int getOrdersInterval() {
		return ordersInterval;
	}
	public void setOrdersInterval(int ordersInterval) {
		this.ordersInterval = ordersInterval;
	}
	public ArrayList<String> getAuthorizedNumbers() {
		return authorizedNumbers;
	}
	public void setAuthorizedNumbers(ArrayList<String> authorizedNumbers) {
		this.authorizedNumbers = authorizedNumbers;
	}
	
	public boolean isValid() {
		if(measureInterval==null) return false;
		if(ordersInterval==null) return false;
		if(authorizedNumbers==null) return  false;
		return true;
	}
	
}
