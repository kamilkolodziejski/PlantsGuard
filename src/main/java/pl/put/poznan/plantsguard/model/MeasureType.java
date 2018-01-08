package pl.put.poznan.plantsguard.model;

public enum MeasureType {
	SOIL ("Soil",0),
	TEMP ("Temperature",1),
	HUMI ("Humidity",2),
	LIGHT ("Light",3);
	
	private final String typeName;
	private final int typeId;
	private final static int typeCount=4;
	MeasureType(String typeName, int typeId) {
		this.typeName=typeName;
		this.typeId=typeId;
		
	}
	private String typeName() { return this.typeName; }
	private int typeId() { return this.typeId; }
	public static int getCount() { return typeCount; }
	public static MeasureType getById(int typeId) {
		for(MeasureType type : MeasureType.values()) {
			if(type.typeId==typeId)
				return type;
		}
		return null;
	}
}
