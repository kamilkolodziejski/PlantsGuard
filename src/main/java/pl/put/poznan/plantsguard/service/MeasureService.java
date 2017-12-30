package pl.put.poznan.plantsguard.service;

import java.sql.Wrapper;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonValue;

import org.joda.time.Days;
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
import com.amazonaws.services.elasticmapreduce.model.Unit;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;

import pl.put.poznan.plantsguard.model.Measure;

@Service
public class MeasureService{ // implements IMeasureService{
	
//	@Autowired
//	MeasuresRepository repository;
	
	static AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion("us-east-2").build();
	static DynamoDB db = new DynamoDB(client);
//	
//	public void save(Measurable measure) {
//		DynamoDBMapper mapper = new DynamoDBMapper(client);
//		mapper.save(measure);
//		//return "[ "+measure.getMeasureDate()+"T"+measure.getMeasureTime()+" ] - Success";
//	}
	
	public String getPeriod(LocalDate fromDate, LocalDate toDate) throws JsonProcessingException {
//		Table table = db.getTable("Measures");
//		QuerySpec query = new QuerySpec()
//				.withKeyConditionExpression(":to <= MeasureData > :from ")
//				.withKeyConditionExpression(" ")
//				.withValueMap(new ValueMap().with(":from",fromDate))
//				.withValueMap(new ValueMap().with(":to", toDate));
//		ItemCollection<QueryOutcome> items = table.query(query);
//		return items.toString();
		ArrayList<Measure> list = new ArrayList<>();
		Duration duration = Duration.between(fromDate, toDate);
		Random rand = new Random();
		for(int i=0; i<duration.toDays(); i++) {
			Measure measure = new Measure();
			measure.setMeasureDate(LocalDate.of(2017, 1, 1+i).format(DateTimeFormatter.BASIC_ISO_DATE), DateTimeFormatter.BASIC_ISO_DATE);
			measure.setHumidity(rand.nextFloat()%i);
			measure.setLight(rand.nextFloat()%i);
			measure.setSoil(rand.nextFloat()%i);
			measure.setTemperature(rand.nextFloat()%i);
			list.add(measure);
		}
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(list);
		return list.toString();
		
	}
	
	public String getFromPeriod(LocalDate fromDate, LocalDate toDate) throws JsonProcessingException {
		ArrayList<Measure> list = new ArrayList<>();
		//Long days = Duration./between(fromDate, toDate).get();
		int days = Period.between(fromDate, toDate).getDays();
		//System.out.println(days);
		Random rand = new Random();
		for(int i=1; i<=days; i++) {
			//System.out.println(fromDate.plusDays(i).format(DateTimeFormatter.BASIC_ISO_DATE).toString());
			Measure measure = new Measure();
			measure.setMeasureDate(fromDate.plusDays(i).format(DateTimeFormatter.BASIC_ISO_DATE).toString(), DateTimeFormatter.BASIC_ISO_DATE);
			measure.setHumidity(rand.nextFloat()%i);
			measure.setLight(rand.nextFloat()%i);
			measure.setSoil(rand.nextFloat()%i);
			measure.setTemperature(36+(rand.nextFloat()%10));
			list.add(measure);
		}
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(list);
		System.out.println(result);
		return result;
	}

}
