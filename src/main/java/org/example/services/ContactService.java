package org.example.services;

import org.example.dtos.ContactRequest;
import org.example.dtos.ContactResponse;
import org.example.dtos.PersonRequest;
import org.example.entities.Contact;

import java.sql.PreparedStatement;

public class ContactService {
    public ContactService() {

    }

    public ContactResponse save(ContactRequest contactRequest) {
        PreparedStatement ps = null;
        {

        }
    }

    public static Contact toContact(ContactRequest contactRequest) {
        return new Contact(contactRequest.getPersonId(),contactRequest.getNumber(),contactRequest.getPrefix());
    }


}
