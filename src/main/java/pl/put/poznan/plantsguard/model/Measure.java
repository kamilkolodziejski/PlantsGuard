package pl.put.poznan.plantsguard.model;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;


@DynamoDBTable(tableName="Measures")
public class Measure extends AbstractMeasure{

	private Float humidity;
	private Float temperature;
	private Float soil;
	private Float light;
	
	public Measure() {
		super();
	}
	
	public Measure(Float humidity, Float temperature, Float soil, Float light) {
		super();
		this.humidity = humidity;
		this.temperature = temperature;
		this.soil = soil;
		this.light = light;
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
