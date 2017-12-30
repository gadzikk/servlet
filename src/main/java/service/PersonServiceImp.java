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
public class PersonServiceImp implements PersonService {
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

    public List<Person> getPersonsBySurname(Parameters params) {
        try {
            return personDao.getPersonsBySurname(params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Person> getPersonsBySurnameWithPagination(Parameters params) {
        try {
            return personDao.getPersonBySurnameWithPagination(params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer countPersons() {
        try {
            return personDao.countPersons();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer countPersonsBySurname(Parameters params) {
        try {
            return personDao.countPersonsBySurname(params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
