package com.example.mongoblog;

import com.example.mongoblog.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MongoBlogApplication {

	@Autowired
	BlogPostRepository groceryItemRepo;

	public static void main(String[] args) {
		SpringApplication.run(MongoBlogApplication.class, args);
	}
}
