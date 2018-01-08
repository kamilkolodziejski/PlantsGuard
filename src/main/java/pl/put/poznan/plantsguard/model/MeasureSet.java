package pl.put.poznan.plantsguard.model;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;


public class MeasureSet extends AbstractMeasure {
	
	private String deviceNumber;
	private HashMap<MeasureType, List<Double>> measureSet;
	
	public MeasureSet() {
		super();
	}
	
	public MeasureSet(String deviceNumber) {
		super();
		Optional<String> opt = Optional.ofNullable(deviceNumber);
		this.deviceNumber=opt.orElse("UNKNOWN");
	}
	public MeasureSet(String deviceNumber, LocalDateTime dateTime) {
		super(dateTime);
		Optional<String> opt = Optional.ofNullable(deviceNumber);
		this.deviceNumber=opt.orElse("UNKNOWN");
	}
	public MeasureSet(String deviceNumber, LocalDateTime dateTime, HashMap<MeasureType, List<Double>> measureSet) {
		super(dateTime);
		Optional<String> opt = Optional.ofNullable(deviceNumber);
		this.deviceNumber=opt.orElse("UNKNOWN");
		this.measureSet=measureSet;
	}
	public MeasureSet(String deviceNumber, HashMap<MeasureType, List<Double>> measureSet, String date, String time) {
		super(date, time);
		Optional<String> opt = Optional.ofNullable(deviceNumber);
		this.deviceNumber=opt.orElse("UNKNOWN");
		this.measureSet=measureSet;
	}
		
	public Double averageMeasure(MeasureType type) {
		return measureSet.get(type).stream().mapToDouble(val -> val).average().getAsDouble();
	}
	
	public HashMap<MeasureType, Double> averageMeasureList() {
		HashMap<MeasureType, Double>list = new HashMap();
		for(Map.Entry<MeasureType, List<Double>> measure : this.measureSet.entrySet()) {
			list.put(measure.getKey(), measure.getValue().stream().mapToDouble(val -> val).average().getAsDouble());
		}
		return list;
	}
	
	public void addMeasure(MeasureType type, Double measure) {
		List<Double> measures = this.measureSet.get(type);
		measures.add(measure);
		this.measureSet.put(type, measures);
	}
	
	public List<Double> getMeasures(MeasureType type) {
		List<Double> list = this.measureSet.get(type);
		return list;
	}
	
	public void setMeasures(MeasureType type, List<Double> measures) {
		this.measureSet.put(type, measures);
	}

	@DynamoDBAttribute(attributeName="MeasureSet")
	public HashMap<MeasureType, List<Double>> getMeasureSet() {
		return this.measureSet;
	}

	public void setMeasureSet(HashMap<MeasureType, List<Double>> measureSet) {
		this.measureSet = measureSet;
	}

	@DynamoDBAttribute(attributeName="DeviceNumber")
	public String getDeviceNumber() {
		return deviceNumber;
	}

	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}	
}
