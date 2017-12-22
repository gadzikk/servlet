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
public class PersonFacade implements PersonRepository {
    public List<Person> getAll() {
        return null;
    }

    public Person getById(PreparedStatement stmt, Parameters params) throws SQLException {
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

    public List<Person> getAll(PreparedStatement stmt) throws SQLException {
        ResultSet rs = stmt.executeQuery();
        List<Person> result = new ArrayList<Person>();
        while (rs.next()){
            Person person = new Person();
            person.setId(rs.getLong("id"));
            person.setLastname(rs.getString("lname"));
            person.setName(rs.getString("name"));
            person.setDate(rs.getDate("dob"));
            result.add(person);
        }
        return result;
    }
}
