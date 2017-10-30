package pl.put.poznan.plantsguard.service;

import java.util.Base64;

import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;

@Service
public class UserService {

	static AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion("us-east-2").build();
	static DynamoDB db = new DynamoDB(client);
	
	public void saveUser(String login, String password) {
		
	}
	
	public boolean authenticate(String user, String password) {
		Table tb = db.getTable("Users");
		String password64 = tb.getItem("login", user).get("password").toString();
		byte[] bytes = Base64.getDecoder().decode(password64);
		if(password.equals(new String(bytes)))
			return true;
		else
			return false;
	}
}
