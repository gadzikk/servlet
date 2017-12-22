package front;

import model.Person;

import java.util.List;

/**
 * Created by gadzik on 21.12.17.
 */
public class PersonData {

    List<Person> persons;
    Person person;

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}
