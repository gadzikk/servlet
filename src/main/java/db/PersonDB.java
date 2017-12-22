package db;

import front.PersonData;
import model.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by gadzik on 21.12.17.
 */
public class PersonDB {
    public PersonData getConnection(String method, Parameters params) {
        final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
        final String USER = "postgres";
        final String PASS = "postgres";

        PersonRepository repository = new PersonFacade();
        PersonData data = new PersonData();

        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            if ("getall".equals(method)) {
                stmt = conn.prepareStatement("SELECT * FROM PERSON");
                List<Person> persons = repository.getAll(stmt);
                data.setPersons(persons);
            } else if ("getbyid".equals(method)) {
                stmt = conn.prepareStatement("SELECT * FROM PERSON WHERE ID = ?");
                Person person = repository.getById(stmt, params);
                data.setPerson(person);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return data;
        }
    }
}
