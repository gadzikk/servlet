package db;

import model.Person;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by gadzik on 23.12.17.
 */
public interface PersonDao {

    Person getById(Parameters params) throws SQLException;
    List<Person> getAll() throws SQLException;
    List<Person> getPersonsBySurname(Parameters params) throws SQLException;
    List<Person> getPersonBySurnameWithPagination(Parameters params) throws SQLException;
    Integer countPersons() throws SQLException;
    Integer countPersonsBySurname(Parameters params) throws SQLException;
}
