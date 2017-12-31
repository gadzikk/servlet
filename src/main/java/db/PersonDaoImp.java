package db;

import model.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by gadzik on 21.12.17.
 */
public class PersonDaoImp implements PersonDao {

    private PersonRepository repository = new PersonJDBC();
    private static Connection conn;

    public Person getById(Parameters params) throws SQLException {
        PreparedStatement stmt = getConn().prepareStatement("SELECT * FROM PERSON WHERE ID = ?");
        return repository.exectueGetById(stmt, params);
    }

    public List<Person> getAll() throws SQLException {
        PreparedStatement stmt = getConn().prepareStatement("SELECT * FROM PERSON");
        return repository.exectueGetAll(stmt);
    }

    public List<Person> getPersonsBySurname(Parameters params) throws SQLException {
        PreparedStatement stmt = getConn().prepareStatement("SELECT * FROM PERSON WHERE LNAME LIKE ?");
        return repository.executeGetBySurname(stmt, params);
    }

    public List<Person> getPersonBySurnameWithPagination(Parameters params) throws SQLException {
        PreparedStatement stmt = getConn().prepareStatement("SELECT * FROM PERSON WHERE LNAME LIKE ? ORDER BY " + params.getOrderby() + " " + params.getOrdering() +  " LIMIT ? OFFSET ?");
        return repository.executeGetBySurnameWithPagination(stmt, params);
    }

    public Integer countPersons() throws SQLException {
        PreparedStatement stmt = getConn().prepareStatement("SELECT COUNT(*) FROM PERSON");
        return repository.executeCountPersons(stmt);
    }

    public Integer countPersonsBySurname(Parameters params) throws SQLException {
        PreparedStatement stmt = getConn().prepareStatement("SELECT COUNT(*) FROM PERSON WHERE LNAME LIKE ?");
        return repository.executeCountPersonsBySurname(stmt, params);
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
