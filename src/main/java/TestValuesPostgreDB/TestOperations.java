package TestValuesPostgreDB;

public class TestOperations {

    public String connectToTable (){
        return  "CREATE TABLE IF NOT EXISTS TEST" +
                "(ID        INT             NOT NULL," +
                " FIRST     NUMERIC(2)      NOT NULL," +
                " SECOND    NUMERIC(2)      NOT NULL," +
                " THIRD     NUMERIC(2)      NOT NULL)";
    }
}
