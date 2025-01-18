package org.example.dtos;

import java.time.LocalDateTime;

public class ContactResponse {
    Long id;
    String prefix;
    String number;
    LocalDateTime created;

    public ContactResponse(Long id, String prefix, String number, LocalDateTime created) {
        this.id = id;
        this.prefix = prefix;
        this.number = number;
        this.created = created;
    }

    public Long getId() {
        return id;
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

