package com.chuwa.CassandraBlog.entity;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;

public class Blog {
    
    @PrimaryKey
    private UUID id;

    private String title;

    private String content;

    private String author;

    public Blog(UUID id, String title, String content, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    
}
