package org.example.repositories;

import org.example.dtos.Person;

import java.util.List;

public interface PersonRepository {
    List<Person> findAll();
    void addPerson(Person person);
    Person findPersonById(long id);
    void updatePerson(long id ,Person person);
    void deletePerson(long id);
}
