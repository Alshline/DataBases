package DatesDataBase;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document (collection = "DateValue")
public class DateValue {

    @Id
    @Getter
    private String id;

    @Setter
    @Getter
    private  String value;

    public DateValue(){
        Date date = new Date();
        this.value=date.toString();
    }

    public String toString(){
        return "Date [id=" +id+ ", value=" +value+ "]";
    }
}
