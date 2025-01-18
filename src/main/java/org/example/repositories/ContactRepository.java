package org.example.repositories;


import org.example.dtos.PersonRequest;
import org.example.dtos.PersonResponse;
import org.example.entities.Contact;

import java.util.List;

public interface ContactRepository {
    List<PersonResponse> findPersonByPrefix(String prefix);
    void saveContact(Contact contact);
}
