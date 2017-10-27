package pl.put.poznan.plantsguard.service;

import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;

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

}
