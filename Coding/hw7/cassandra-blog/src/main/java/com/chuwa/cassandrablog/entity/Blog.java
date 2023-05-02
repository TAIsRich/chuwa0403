package com.chuwa.cassandrablog.entity;


import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table
public class Blog {
    @PrimaryKey
    private UUID id;
    private String message;
    private String byName;

    public Blog(UUID id, String message, String byName) {
        this.id = id;
        this.message = message;
        this.byName = byName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getByName() {
        return byName;
    }

    public void setByName(String byName) {
        this.byName = byName;
    }
}