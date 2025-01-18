package org.example.dtos;

import java.time.LocalDateTime;

public class ContactRequest {
    String prefix;
    String number;
    Long personId;

    public ContactRequest(String prefix, String number) {
        this.prefix = prefix;
        this.number = number;
    }

    public ContactRequest(String prefix, String number, Long personId) {
        this.prefix = prefix;
        this.number = number;
        this.personId = personId;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getNumber() {
        return number;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }
}

