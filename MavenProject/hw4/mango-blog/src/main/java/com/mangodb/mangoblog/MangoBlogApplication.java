package com.mangodb.mangoblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import com.mangodb.mangoblog.repository.BlogPostRepository;

@SpringBootApplication
@EnableMongoRepositories
public class MangoBlogApplication {

    private BlogPostRepository blogPostRepository;

    public static void main(String[] args) {

        SpringApplication.run(MangoBlogApplication.class, args);
    }

}
