package com.chuwa.mongoredbook.dao;

import com.chuwa.mongoredbook.model.Blog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlogRepository extends MongoRepository<Blog, String> {
}
