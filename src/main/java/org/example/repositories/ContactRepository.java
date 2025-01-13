package org.example.repositories;

import org.example.dtos.Person;

import java.util.List;

public interface ContactRepository {
    List<Person> findPersonByPrefix(String prefix);
}
