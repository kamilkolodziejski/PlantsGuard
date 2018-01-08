package pl.put.poznan.plantsguard.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;


public class MeasureSetWrapper {
	
	private String deviceNumber;
	private String mdate;
	private String mtime;
	private Double[] humi;
	private Double[] temp;
	private Double[] light;
	private Double[] soil;
	
	public MeasureSet getMeasureSet() {
		HashMap<MeasureType, List<Double>> measures = new HashMap<>();
		if(this.soil!=null)
			measures.put(MeasureType.SOIL, new ArrayList<Double>(Arrays.asList(this.soil)));
		if(this.humi!=null)
			measures.put(MeasureType.HUMI, new ArrayList<Double>(Arrays.asList(this.humi)));
		if(this.temp!=null)
			measures.put(MeasureType.TEMP, new ArrayList<Double>(Arrays.asList(this.temp)));
		if(this.light!=null)
			measures.put(MeasureType.LIGHT, new ArrayList<Double>(Arrays.asList(this.light)));
		MeasureSet set = new MeasureSet(this.deviceNumber, measures, this.mdate, this.mtime);
		return set;
	}	
	
	public MeasureSetWrapper() { }
	
//	public MeasureSetWrapper(String deviceNumber, String mdate, String mtime, Double[] humi, Double[] temp,
//			Double[] light, Double[] soil) {
//		super();
//		this.deviceNumber = deviceNumber;
//		this.mdate = mdate;
//		this.mtime = mtime;
//		this.humi = humi;
//		this.temp = temp;
//		this.light = light;
//		this.soil = soil;
//	}

	public String getDeviceNumber() {
		return deviceNumber;
	}

	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}

	public String getMdate() {
		return mdate;
	}

	public void setMdate(String mdate) {
		this.mdate = mdate;
	}

	public String getMtime() {
		return mtime;
	}

	public void setMtime(String mtime) {
		this.mtime = mtime;
	}

	public Double[] getHumi() {
		return humi;
	}

	public void setHumi(Double[] humi) {
		this.humi = humi;
	}

	public Double[] getTemp() {
		return temp;
	}

	public void setTemp(Double[] temp) {
		this.temp = temp;
	}

	public Double[] getLight() {
		return light;
	}

	public void setLight(Double[] light) {
		this.light = light;
	}

	public Double[] getSoil() {
		return soil;
	}

	public void setSoil(Double[] soil) {
		this.soil = soil;
	}

}
