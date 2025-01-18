package org.example.repositories;

import org.example.dtos.PersonResponse;
import org.example.entities.Contact;

import java.util.List;

public class ContactRepositoryImpl implements ContactRepository {
    @Override
    public List<PersonResponse> findPersonByPrefix(String prefix) {
        return List.of();
    }

    @Override
    public void saveContact(Contact contact) {

    }
}
