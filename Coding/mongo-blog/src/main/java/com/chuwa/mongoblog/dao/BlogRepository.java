package com.chuwa.mongoblog.dao;

import com.chuwa.mongoblog.entity.Blog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface BlogRepository extends MongoRepository<Blog, String> {

}
