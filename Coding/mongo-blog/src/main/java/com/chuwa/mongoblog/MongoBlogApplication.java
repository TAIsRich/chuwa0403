package com.chuwa.mongoblog;

import com.chuwa.mongoblog.dao.BlogRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MongoBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoBlogApplication.class, args);
	}

}
