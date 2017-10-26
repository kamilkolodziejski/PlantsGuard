package pl.put.poznan.plantsguard.service;

import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;

import pl.put.poznan.plantsguard.model.JsonMeasuresBuilder;
import pl.put.poznan.plantsguard.model.Measure;

@Service
public class MeasureService {
	
//	@Autowired
//	MeasuresRepository repository;
	
	static AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion("us-east-2").build();
	static DynamoDB db = new DynamoDB(client);
	
	public void save(Measure measure) {
		Table table = db.getTable("Measures");
		JsonMeasuresBuilder builder = new JsonMeasuresBuilder();
		
		Item item = Item.fromJSON(builder.createJsonFromMeasure(measure).toString());
		
		table.putItem(item);
	}

}
