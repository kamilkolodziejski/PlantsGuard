package pl.put.poznan.plantsguard.model;

public class MeasureWrapper implements Measurable{

	private Float temp;
	private Float humi;
	private Float light;
	private Float soil;
	
	@Override
	public Measure measurable() {
		Measure measure = new Measure(humi, temp, soil, light);		
		return measure;
	}

	public Float getTemp() {
		return temp;
	}

	public void setTemp(Float temp) {
		this.temp = temp;
	}

	public Float getHumi() {
		return humi;
	}

	public void setHumi(Float humi) {
		this.humi = humi;
	}

	public Float getLight() {
		return light;
	}

	public void setLight(Float light) {
		this.light = light;
	}

	public Float getSoil() {
		return soil;
	}

	public void setSoil(Float soil) {
		this.soil = soil;
	}
	
}
