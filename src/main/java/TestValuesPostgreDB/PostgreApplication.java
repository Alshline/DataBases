package TestValuesPostgreDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@SpringBootApplication
public class PostgreApplication {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) throws SQLException {

        SpringApplication.run(PostgreApplication.class, args);
    }

    public void run(String... args){

        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("org.postgresql.Driver");
            connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/TestValues",
                    "postgres", "root");
            connection.setAutoCommit(false);

            TestOperations testOperations = new TestOperations();

            statement = connection.createStatement();
            String sql = testOperations.connectToTable();
            statement.execute(sql);

            statement.close();
            connection.commit();
            connection.close();
        } catch (Exception exception){
            exception.printStackTrace();
            System.err.println(exception.getClass().getName()+": "+exception.getMessage());
            System.exit(0);
        }

        System.out.println("Opened database successfully");

    }
}
