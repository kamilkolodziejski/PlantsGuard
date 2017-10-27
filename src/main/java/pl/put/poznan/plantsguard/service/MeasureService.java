package pl.put.poznan.plantsguard.service;

import java.sql.Wrapper;
import java.util.Iterator;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;

import org.socialsignin.spring.data.dynamodb.repository.query.DynamoDBCountQueryCreator;
import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazonaws.services.dynamodbv2.model.QueryRequest;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;

import pl.put.poznan.plantsguard.model.Measure;
import pl.put.poznan.plantsguard.utils.JsonMeasuresBuilder;

@Service
public class MeasureService {
	
//	@Autowired
//	MeasuresRepository repository;
	
	static AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion("us-east-2").build();
	static DynamoDB db = new DynamoDB(client);
//	
	public String save(Measure measure) {
		DynamoDBMapper mapper = new DynamoDBMapper(client);
		mapper.save(measure);
		return "[ "+measure.getMeasureDate()+"T"+measure.getMeasureTime()+" ] - Success";
	}
	
	public JsonArray getFromPeriod(String from, String to) {
		Table table = db.getTable("Measures");
		QuerySpec query = new QuerySpec()
				.withKeyConditionExpression("MeasureDate > :from")
				.withValueMap(new ValueMap().with(":from", from));
		ItemCollection<QueryOutcome> items = table.query(query);
		Item item = null;
		Iterator<Item> it = items.iterator();
		JsonArrayBuilder array = Json.createArrayBuilder();
		while(it.hasNext()) {
			array.add(item.toJSON());
		}
		return array.build();
//		QueryRequest req = new QueryRequest("Measures");
//		req.addQueryFilterEntry("MeasureDate",
//		DynamoDBMapper mapper = new DynamoDBMapper(client);
//		DynamoDBEntityWithHashKeyOnlyCriteria entity = new DynamoDBE
//		DynamoDBCountQueryCreator<Measure, >
//		mapper.query(Measure.class, )
	}

}
