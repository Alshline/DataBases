package TestValuesPostgreDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgreApplication {

    public static void main(String[] args) throws SQLException {

        Connection c = null;
        Statement statement = null;

        try {
            Class.forName("org.postgresql.Driver");
            c= DriverManager.getConnection("jdbc:postgresql://localhost:5432/TestValues",
                    "postgres", "root");
            c.setAutoCommit(false);

            TestOperations testOperations = new TestOperations();

            statement = c.createStatement();
            String sql = testOperations.connectToTable();
            statement.execute(sql);

            statement.close();
            c.commit();
            c.close();
        } catch (Exception exception){
            exception.printStackTrace();
            System.err.println(exception.getClass().getName()+": "+exception.getMessage());
            System.exit(0);
        }

        System.out.println("Opened database successfully");


    }
}
