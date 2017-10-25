package pl.put.poznan.plantsguard.model;

public class ReportRequest {

	private String phone;
	private Float humi;
	private Float temp;
	private Float soil;
	private Float light;
	private Float batt;
	private Float water;
	private Float ballance;

	public ReportRequest() {}

	public ReportRequest(String phone, Float humi, Float temp, Float soil, Float light, Float batt, Float water,
			Float ballance) {
		super();
		this.phone = phone;
		this.humi = humi;
		this.temp = temp;
		this.soil = soil;
		this.light = light;
		this.batt = batt;
		this.water = water;
		this.ballance = ballance;
	}
	
	public Measure createMeasure() {
		Measure measure = new Measure(this.humi, this.temp, this.soil, this.light, this.batt);
		return measure;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Float getHumi() {
		return humi;
	}

	public void setHumi(Float humi) {
		this.humi = humi;
	}

	public Float getTemp() {
		return temp;
	}

	public void setTemp(Float temp) {
		this.temp = temp;
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

	public Float getBatt() {
		return batt;
	}

	public void setBatt(Float batt) {
		this.batt = batt;
	}

	public Float getWater() {
		return water;
	}

	public void setWater(Float water) {
		this.water = water;
	}

	public Float getBallance() {
		return ballance;
	}

	public void setBallance(Float ballance) {
		this.ballance = ballance;
	}

	@Override
	public String toString() {
		return "ReportRequest [phone=" + phone + ", humi=" + humi + ", temp=" + temp + ", soil=" + soil + ", light="
				+ light + ", batt=" + batt + ", water=" + water + ", ballance=" + ballance + "]";
	};
	
}
