package utils;

import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.json.JsonValue;

import pl.put.poznan.plantsguard.model.Measure;
import pl.put.poznan.plantsguard.model.MeasureDataSet;

public class JsonMeasuresBuilder {
	

	public JsonObject createJsonFromMeasure(Measure measure) {		
//		JsonArrayBuilder colsArrayBuilder = factory.createArrayBuilder()
//						.add(factory.createObjectBuilder()
//								.add("id",JsonValue.NULL)
//								.add("label", "MeasureDate")
//								.add("pattern",JsonValue.NULL)
//								.add("type", "date"));
//		System.out.println(colsArrayBuilder.toString());
//		JsonObject response = factory.createObjectBuilder().add("cols", colsArray)
//		return colsArray;
		
		JsonObject jsonObject = Json.createObjectBuilder().add("temp", measure.getTemperature())
														  .add("humidity", measure.getHumidity())
														  .build();
		return jsonObject;
	};
	
	
	public JsonObject createJsonFromDataSet(MeasureDataSet dataSet) {
	
		List<Measure> measures = dataSet.getMeasureList();
		
		JsonBuilderFactory factory = Json.createBuilderFactory(null);
//		JsonArrayBuilder colsArrayBuilder = factory.createArrayBuilder()
//						.add(factory.createObjectBuilder()
//								.add("id",JsonValue.NULL)
//								.add("label", "MeasureDate")
//								.add("pattern",JsonValue.NULL)
//								.add("type", "date"));
//		System.out.println(colsArrayBuilder.toString());
//		JsonObject response = factory.createObjectBuilder().add("cols", colsArray)
//		return colsArray;
		
		JsonArrayBuilder colsArrayBuilder = factory.createArrayBuilder()
						.add(factory.createObjectBuilder()
								.add("id",JsonValue.NULL)
								.add("label", "MeasureDate")
								.add("pattern",JsonValue.NULL)
								.add("type", "date"))
						.add(factory.createObjectBuilder()
								.add("id",JsonValue.NULL)
								.add("label", "Temperature")
								.add("pattern",JsonValue.NULL)
								.add("type", "number"));
		JsonArrayBuilder rowsArrayBuilder = factory.createArrayBuilder();

		for(Measure item : measures) {
			rowsArrayBuilder.add(factory.createObjectBuilder()
					.add("c", factory.createArrayBuilder()
							.add(factory.createObjectBuilder()
									.add("v", "Date("+item.extractLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy, MM, dd"))+")")
									.add("f",JsonValue.NULL))
							.add(factory.createObjectBuilder()
									.add("v", item.getTemperature())
									.add("f", JsonValue.NULL))));
		}
		JsonObject jsonTable = factory.createObjectBuilder()
				.add("cols", colsArrayBuilder)
				.add("rows", rowsArrayBuilder).build();
		return jsonTable;
	};
}
