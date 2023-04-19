package com.example.mongoblog.repository;

import com.example.mongoblog.entity.BlogEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlogRepository extends MongoRepository<BlogEntity, String> {
}
