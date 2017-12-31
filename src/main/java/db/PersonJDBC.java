package db;

import model.Person;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gadzik on 21.12.17.
 */
public class PersonJDBC implements PersonRepository {

    public Person exectueGetById(PreparedStatement stmt, Parameters params) throws SQLException {
        stmt.setLong(1, params.getId());
        ResultSet rs = stmt.executeQuery();
        Person person = new Person();
        while (rs.next()) {
            person.setId(rs.getLong("id"));
            person.setLastname(rs.getString("lname"));
            person.setName(rs.getString("name"));
            person.setDate(rs.getDate("dob"));
        }
        return person;
    }

    public List<Person> exectueGetAll(PreparedStatement stmt) throws SQLException {
        ResultSet rs = stmt.executeQuery();
        List<Person> result = new ArrayList<Person>();
        while (rs.next()) {
            Person person = new Person();
            person.setId(rs.getLong("id"));
            person.setLastname(rs.getString("lname"));
            person.setName(rs.getString("name"));
            person.setDate(rs.getDate("dob"));
            result.add(person);
        }
        return result;
    }

    public List<Person> executeGetBySurname(PreparedStatement stmt, Parameters params) throws SQLException {
        stmt.setString(1, "%" + params.getName() + "%");
        ResultSet rs = stmt.executeQuery();
        List<Person> result = new ArrayList<Person>();
        while (rs.next()) {
            Person person = new Person();
            person.setId(rs.getLong("id"));
            person.setDate(rs.getDate("dob"));
            person.setLastname(rs.getString("lname"));
            person.setName(rs.getString("name"));
            result.add(person);
        }
        return result;
    }

    public List<Person> executeGetBySurnameWithPagination(PreparedStatement stmt, Parameters params) throws SQLException {
        stmt.setString(1, "%" + params.getName() + "%");
        stmt.setInt(2, 10);
        stmt.setInt(3, (params.getPage() - 1) * 10);
        ResultSet rs = stmt.executeQuery();
        List<Person> result = new ArrayList<Person>();
        while (rs.next()) {
            Person person = new Person();
            person.setId(rs.getLong("id"));
            person.setDate(rs.getDate("dob"));
            person.setLastname(rs.getString("lname"));
            person.setName(rs.getString("name"));
            result.add(person);
        }
        return result;
    }

    public Integer executeCountPersons(PreparedStatement stmt) throws SQLException {
        ResultSet rs = stmt.executeQuery();
        int total = 0;
        while (rs.next()) {
            total = rs.getInt(1);
        }
        return total;
    }

    public Integer executeCountPersonsBySurname(PreparedStatement stmt, Parameters params) throws SQLException {
        stmt.setString(1, "%" + params.getName() + "%");
        ResultSet rs = stmt.executeQuery();
        int total = 0;
        while (rs.next()) {
            total = rs.getInt(1);
        }
        return total;
    }
}
