package org.example.repositories;

import org.example.dtos.Person;

import java.util.ArrayList;
import java.util.List;

public class InMemoryPersonRepoImp implements PersonRepository{
    List<Person> persons = new ArrayList<>();
    @Override
    public List<Person> findAll() {
        return persons;
    }

    @Override
    public void addPerson(Person person) {
        persons.add(person);
    }

    @Override
    public Person findPersonById(long id) {
        return null;
    }

    @Override
    public void updatePerson(long id, Person person) {

    }

    @Override
    public void deletePerson(long id) {

    }
}
