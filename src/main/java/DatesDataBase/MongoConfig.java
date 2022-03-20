package DatesDataBase;

import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.mongodb.client.MongoClient;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    public String getDatabaseName() {
        return "DatesDB";
    }

    @Bean
    public MongoClient mongoClient(){
        return MongoClients.create("mongodb://localhost:27017");
    }
}
