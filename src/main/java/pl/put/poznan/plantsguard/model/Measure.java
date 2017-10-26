package pl.put.poznan.plantsguard.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="Measures")
public class Measure {

	private LocalDateTime measureDateTime;
	private String measureDate;
	private String measureTime;
	private Float humidity;
	private Float temperature;
	private Float soil;
	private Float light;
	
	public Measure() {
		this.measureDateTime = LocalDateTime.now();
		this.measureDate = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE).toString();
		this.measureTime = measureDateTime.format(DateTimeFormatter.ISO_TIME).toString();
	}

	public Measure(Float humidity, Float temperature, Float soil, Float light) {
		super();
		this.measureDateTime = LocalDateTime.now();
		this.measureDate = this.measureDateTime.format(DateTimeFormatter.ISO_DATE).toString();
		this.measureTime = this.measureDateTime.format(DateTimeFormatter.ISO_TIME).toString();
		this.humidity = humidity;
		this.temperature = temperature;
		this.soil = soil;
		this.light = light;
	}

	@DynamoDBHashKey(attributeName="MeasureDate")
	public String getMeasureDate() {
		return this.measureDate;
	}

	@DynamoDBRangeKey(attributeName="MeasureTime")
	public String getMeasureTime() {
		return this.measureTime;
	}

	@DynamoDBAttribute(attributeName="Humidity")
	public Float getHumidity() {
		return humidity;
	}

	@DynamoDBAttribute(attributeName="Temperature")
	public Float getTemperature() {
		return temperature;
	}

	@DynamoDBAttribute(attributeName="Soil")
	public Float getSoil() {
		return soil;
	}
	
	@DynamoDBAttribute(attributeName="Light")
	public Float getLight() {
		return light;
	}
	
	public LocalDateTime getMeasureLocalDateTime() {
		return this.measureDateTime;
	}
	
	public void setMeasureDate(LocalDateTime measureDateTime) {
		this.measureDateTime = measureDateTime;
		this.measureDate = this.measureDateTime.format(DateTimeFormatter.ISO_DATE).toString();
		this.measureTime = this.measureDateTime.format(DateTimeFormatter.ISO_TIME).toString();
	}

	public void setHumidity(Float humidity) {
		this.humidity = humidity;
	}

	public void setTemperature(Float temperature) {
		this.temperature = temperature;
	}

	public void setSoil(Float soil) {
		this.soil = soil;
	}

	public void setLight(Float light) {
		this.light = light;
	}
}
