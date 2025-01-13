package org.example.services;

import org.example.dtos.Person;

import org.example.repositories.PersonRepository;

public class PersonService {
    PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void add(Person person) {
        personRepository.addPerson(person);
    }
}
