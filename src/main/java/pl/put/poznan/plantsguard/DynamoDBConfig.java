package pl.put.poznan.plantsguard;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

@Configuration
@EnableDynamoDBRepositories
  (basePackages = "pl.put.poznan.plantsguard.service")
public class DynamoDBConfig { 
	
    @Value("${amazon.dynamodb.endpoint}")
    private String amazonDynamoDBEndpoint;
    
    @Value("${amazon.dynamodb.region}")
    private String amazonDynamoDBRegion;
 
 
    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        AmazonDynamoDB amazonDynamoDB 
          = AmazonDynamoDBClientBuilder.standard().withRegion(amazonDynamoDBRegion).build();//configureRegion("us-east-2"); //amazonAWSCredentials());
         
//        if (!StringUtils.isEmpty(amazonDynamoDBEndpoint)) {
//            amazonDynamoDB.setEndpoint(amazonDynamoDBEndpoint);
//        }
//        if(!StringUtils.isEmpty(amazonDynamoDBRegion)) {
//        	amazonDynamoDB.setRegion(Region.getRegion(com)));
//        }
         
        return amazonDynamoDB;
    }
 
//    @Bean
//    public AWSCredentials amazonAWSCredentials() {
//        return new BasicAWSCredentials(
//          amazonAWSAccessKey, amazonAWSSecretKey);
//    }

}
