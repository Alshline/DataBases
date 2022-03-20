package DatesDataBase;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

public class DateOperations {

    public void saveDate (MongoOperations mongoOperations, DateValue dateValue){

        mongoOperations.save(dateValue);
    }

    public String searchDate (MongoOperations mongoOperations, String criteria, String value){

        Query searchDateValue = new Query(Criteria.where(criteria).is(value));
        DateValue resultDateValue = mongoOperations.findOne(searchDateValue,DateValue.class);
        return resultDateValue.toString();
    }

    public void updateDateValue (MongoOperations mongoOperations, String criteria, String value,
                                 String updateCriteria, String updateValue){

        Query searchDateValue = new Query(Criteria.where(criteria).is(value));
        mongoOperations.updateFirst(searchDateValue, Update.update(updateCriteria, updateValue), DateValue.class);
    }

    public List getAllDateValues (MongoOperations mongoOperations){

        List listDateValues = mongoOperations.findAll(DateValue.class);
        return listDateValues;
    }

    public void removeDateValue (MongoOperations mongoOperations, String criteria, String value){

        Query searchDateValue = new Query(Criteria.where(criteria).is(value));
        mongoOperations.remove(searchDateValue,DateValue.class);
    }

}
