package com.example.mongoblog.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("BlogItem")
public class BlogItem {
    @Id
    private String id;
    private String title;
    private String content;

    public BlogItem(String id, String title, String content) {
        super();
        this.id = id;
        this.title = title;
        this.content = content;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }
}
