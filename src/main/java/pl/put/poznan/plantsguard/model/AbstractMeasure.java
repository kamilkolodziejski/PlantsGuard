package pl.put.poznan.plantsguard.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;


public abstract class AbstractMeasure{

	protected LocalDateTime measureCreationTime;
	
	public AbstractMeasure() {
		this.measureCreationTime = LocalDateTime.now();
	}
	public AbstractMeasure(LocalDateTime dateTime) {
		this.measureCreationTime = dateTime;
	}
	public AbstractMeasure(String measureDate, String measureTime) {
		this.measureCreationTime = LocalDateTime.of(LocalDate.parse(measureDate, DateTimeFormatter.BASIC_ISO_DATE), LocalTime.parse(measureTime, DateTimeFormatter.ISO_TIME));
	}

	@DynamoDBHashKey(attributeName="MeasureDate")
	public String getMeasureDate() {
		return this.measureCreationTime.format(DateTimeFormatter.BASIC_ISO_DATE).toString();
	}

	@DynamoDBRangeKey(attributeName="MeasureTime")
	public String getMeasureTime() {
		return this.measureCreationTime.format(DateTimeFormatter.ISO_TIME).toString();
	}

	@DynamoDBHashKey(attributeName="MeasureDate")
	public void setMeasureDate(String date) {
		this.measureCreationTime = LocalDateTime.of(LocalDate.parse(date, DateTimeFormatter.BASIC_ISO_DATE), this.measureCreationTime.toLocalTime());
	}

	@DynamoDBRangeKey(attributeName="MeasureTime")
	public void setMeasureTime(String time) {
		this.measureCreationTime = LocalDateTime.of(this.measureCreationTime.toLocalDate(), LocalTime.parse(time, DateTimeFormatter.ISO_TIME));
	}

	
	public LocalDateTime measureCreationTime() {
		return this.measureCreationTime;
		
	}
	
	public void atMeasureCreationTime(LocalDateTime measureCreationTime) {
		this.measureCreationTime = measureCreationTime;
	}
	
}
