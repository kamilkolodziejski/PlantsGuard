package pl.put.poznan.plantsguard.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Measure {

	private LocalDateTime measureDateTime = LocalDateTime.now();
	private String measureDate = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE).toString();
	private String measureTime = measureDateTime.format(DateTimeFormatter.ISO_TIME).toString();
	private Float humidity;
	private Float temperature;
	private Float soil;
	private Float light;
	private Float battery;
	
	public Measure() {	}

	public Measure(Float humidity, Float temperature, Float soil, Float light, Float battery) {
		super();
		this.measureDateTime = LocalDateTime.now();
		this.measureDate = this.measureDateTime.format(DateTimeFormatter.ISO_DATE).toString();
		this.measureTime = this.measureDateTime.format(DateTimeFormatter.ISO_TIME).toString();
		this.humidity = humidity;
		this.temperature = temperature;
		this.soil = soil;
		this.light = light;
		this.battery = battery;
	}

	public String getMeasureDate() {
		return this.measureDate;
	}

	public String getMeasureTime() {
		return this.measureTime;
	}
	
	public LocalDateTime getMeasureLocalDateTime() {
		return this.measureDateTime;
	}
	
	public void setMeasureDate(LocalDateTime measureDateTime) {
		this.measureDateTime = measureDateTime;
		this.measureDate = this.measureDateTime.format(DateTimeFormatter.ISO_DATE).toString();
		this.measureTime = this.measureDateTime.format(DateTimeFormatter.ISO_TIME).toString();
	}

	public Float getHumidity() {
		return humidity;
	}

	public void setHumidity(Float humidity) {
		this.humidity = humidity;
	}

	public Float getTemperature() {
		return temperature;
	}

	public void setTemperature(Float temperature) {
		this.temperature = temperature;
	}

	public Float getSoil() {
		return soil;
	}

	public void setSoil(Float soil) {
		this.soil = soil;
	}

	public Float getLight() {
		return light;
	}

	public void setLight(Float light) {
		this.light = light;
	}

	public Float getBattery() {
		return battery;
	}

	public void setBattery(Float battery) {
		this.battery = battery;
	}
}
