package front;

import model.Person;

import java.util.List;

/**
 * Created by gadzik on 21.12.17.
 */
public class PersonData {

    private List<Person> persons;
    private Person person;
    private Integer total;

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

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
