package org.example;

import org.example.dtos.Person;
import org.example.repositories.DbPersonRepoImpl;
import org.example.services.PersonService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    PersonService personService;
    List<Person> persons = new ArrayList<>();
    public static void main(String[] args) {

        Contact c1 = new Contact(1L,"055","1233434",LocalDateTime.now());
        Contact c2 = new Contact(2L,"050","23424",LocalDateTime.now());

        Person p = new Person("123AA","test","test1");
        Main m = new Main();
        m.add(p);
    }

    void add(Person person) {
//        PersonService ps = new PersonService(new InMemoryPersonRepoImp());
        PersonService ps = new PersonService(new DbPersonRepoImpl());
        ps.add(person);
    }

    void update(Long id, Person personUpdate) {
        for(Person person : persons){
            if (person.getId() == id){
//                person.set()
                return;
            }
        }
    }
    List<Person> getAll(){
        return persons;
    }

    void delete(long id){
        for(Person person : persons){
            if (person.getId() == id){
                persons.remove(person);
                return;
            }
        }

    }

    List<Person> findPersonByContact(Contact contact){
        return null;
    }
}