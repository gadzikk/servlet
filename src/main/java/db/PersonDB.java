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
    private static Connection conn;
    private PersonRepository repository = new PersonFacade();


    public PersonData getAll() throws SQLException {
        PersonData data = new PersonData();
        PreparedStatement stmt = getConn().prepareStatement("SELECT * FROM PERSON");
        List<Person> persons = repository.getAll(stmt);
        data.setPersons(persons);
        return data;
    }

    public PersonData getById(Parameters params) throws SQLException {
        PersonData data = new PersonData();
        PreparedStatement stmt = getConn().prepareStatement("SELECT * FROM PERSON WHERE ID = ?");
        Person person = repository.getById(stmt, params);
        data.setPerson(person);
        return data;
    }

    private Connection getConn() {
        final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
        final String USER = "postgres";
        final String PASS = "postgres";

        if (conn != null) {
            return conn;
        } else {
            Connection conn = null;
            try {
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return conn;
        }
    }
}
