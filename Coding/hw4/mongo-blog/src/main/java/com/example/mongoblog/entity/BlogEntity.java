package com.example.mongoblog.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class BlogEntity {
    private String id;
    private String name;
    private String author;
}
