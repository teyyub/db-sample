package org.example;

import jdk.jshell.execution.Util;
import org.example.dtos.GenericResponse;
import org.example.dtos.PersonRequest;
import org.example.entities.Contact;
import org.example.entities.Person;
import org.example.repositories.ContactRepositoryImpl;
import org.example.repositories.DbPersonRepoImpl;
import org.example.repositories.PersonRepository;
import org.example.services.PersonService;
import org.example.utils.DbUtils;
import org.example.utils.PersonRepoFactory;
import org.example.utils.TransactionHelper;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    PersonService personService;
    List<Person> persons = new ArrayList<>();
    public static void main(String[] args) throws Exception {

        Contact c1 = new Contact(1L,"055","1233434",LocalDateTime.now());
        Contact c2 = new Contact(2L,"050","23424",LocalDateTime.now());

        PersonRequest p = new PersonRequest("123AA","test","test1");
        Main m = new Main();
        m.add(p);
    }

    void add(PersonRequest person) throws Exception {
//        PersonService ps = new PersonService(new InMemoryPersonRepoImp());
        Connection connection = DbUtils.getConn();
//        TransactionHelper transactionHelper = new TransactionHelper(connection);
        PersonRepoFactory factory = new PersonRepoFactory();

        DbPersonRepoImpl repository = factory.createPersonRepo();
        repository.setConnection(connection);
        PersonService ps = new PersonService(
                repository
//                new ContactRepositoryImpl(),
//                transactionHelper);
        );
        GenericResponse<?> result =  ps.add(person);
        System.out.println(result.getMessage());
        System.out.println(result.getData().toString());
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

