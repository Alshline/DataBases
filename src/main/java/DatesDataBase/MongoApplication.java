package DatesDataBase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import java.util.Date;


public class MongoApplication {

     public static void main(String[] args) throws Exception{

         ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MongoConfig.class);
         MongoOperations mongoOperations = (MongoOperations) applicationContext.getBean("mongoTemplate");
         DateOperations dateOperations = new DateOperations();

         DateValue dateValue = new DateValue();

         dateOperations.saveDate(mongoOperations,dateValue);
     }
}
