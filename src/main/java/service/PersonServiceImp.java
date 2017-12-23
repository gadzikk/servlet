package service;

import db.Parameters;
import db.PersonDao;
import db.PersonDaoImp;
import model.Person;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by gadzik on 23.12.17.
 */
public class PersonServiceImp implements PersonService{
    PersonDao personDao = new PersonDaoImp();
    public Person getById(Parameters params) {
        try {
            return personDao.getById(params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Person> getAll() {
        try {
            return personDao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
