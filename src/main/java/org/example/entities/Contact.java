package org.example.entities;

import java.time.LocalDateTime;

public class Contact {
    Long id;
    String prefix;
    String number;
    LocalDateTime created;
    Long personId;
    public Contact(String prefix, String number) {
        this.prefix = prefix;
        this.number = number;
    }

    public Contact(Long personId, String prefix, String number) {
        this.personId = personId;
        this.prefix = prefix;
        this.number = number;
    }

    public Contact(Long id, String prefix, String number, LocalDateTime created) {
        this.id = id;
        this.prefix = prefix;
        this.number = number;
        this.created = created;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getNumber() {
        return number;
    }

    public LocalDateTime getCreated() {
        return created;
    }
}

