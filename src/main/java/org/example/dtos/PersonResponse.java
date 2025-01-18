package org.example.dtos;

import org.example.entities.Contact;

import java.time.LocalDateTime;
import java.util.List;

public class PersonResponse {
        Long id;
        String fin;
        String name;
        String surname;
        //LocalDateTime created;
        Long createdBy;
        List<Contact> contacts;

    public PersonResponse(Long id, String name, String surname, LocalDateTime created, List<Contact> contacts) {
        this.id = id;
        this.name = name;
        this.surname = surname;
       // this.created = created;
        this.contacts = contacts;
    }

    public PersonResponse(Long id, String fin, String name, String surname) {
        this.id = id;
        this.fin = fin;
        this.name = name;
        this.surname = surname;
    }

    public PersonResponse(String fin, String name, String surname) {
        this.fin = fin;
        this.name = name;
        this.surname = surname;
    }

    public String getFin() {
        return fin;
    }

    public Long getId() {
        return id;
    }

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

    @Override
    public String toString() {
        return "PersonResponse{" +
                "id=" + id +
                ", fin='" + fin + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", createdBy=" + createdBy +
                ", contacts=" + contacts +
                '}';
    }
}
