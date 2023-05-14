package com.chuwa.CassandraBlog.dto;

import java.util.UUID;

public class BlogDto {
    private UUID id;
    private String message;
    private String byName;

    public BlogDto(String message, String byName) {
        this.message = message;
        this.byName = byName;
    }

    public BlogDto() {

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

    public String toString() {
        return "BlogDto{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", byName='" + byName + '\'' +
                '}';
    }
}
