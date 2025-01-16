package org.example.dtos;

import org.example.Contact;

import java.time.LocalDateTime;
import java.util.List;

public class PersonRequest {
//        Long id;
        String fin;
        String name;
        String surname;
//        LocalDateTime created;
        Long createdBy;
        List<Contact> contacts;



    public PersonRequest(String fin, String name, String surname) {
        this.fin = fin;
        this.name = name;
        this.surname = surname;
    }

    public String getFin() {
        return fin;
    }

//    public Long getId() {
//        return id;
//    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

//    public LocalDateTime getCreated() {
//        return created;
//    }

    public List<Contact> getContacts() {
        return contacts;
    }
}
