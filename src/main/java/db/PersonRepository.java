package db;

import model.Person;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by gadzik on 21.12.17.
 */
public interface PersonRepository {

    Person exectueGetById(PreparedStatement stmt, Parameters params) throws SQLException;
    List<Person> exectueGetAll(PreparedStatement stmt) throws SQLException;
    List<Person> executeGetBySurname(PreparedStatement stmt,Parameters params) throws SQLException;
}
