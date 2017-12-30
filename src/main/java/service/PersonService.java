package service;

import db.Parameters;
import model.Person;

import java.util.List;

/**
 * Created by gadzik on 23.12.17.
 */
public interface PersonService {

    Person getById(Parameters params);
    List<Person> getAll();
    List<Person> getPersonsBySurname(Parameters params);
    List<Person> getPersonsBySurnameWithPagination(Parameters params);
    Integer countPersons();
    Integer countPersonsBySurname(Parameters params);
}
