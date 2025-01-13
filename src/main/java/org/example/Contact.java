package org.example;

import java.time.LocalDateTime;

public class Contact {
    Long id;
    String prefix;
    String number;
    LocalDateTime created;

    public Contact(Long id, String prefix, String number, LocalDateTime created) {
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

