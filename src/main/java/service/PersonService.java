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
}
