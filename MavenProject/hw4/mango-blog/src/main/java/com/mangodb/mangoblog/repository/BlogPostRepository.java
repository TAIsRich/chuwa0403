package com.mangodb.mangoblog.repository;

import com.mangodb.mangoblog.Model.BlogPost;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlogPostRepository extends MongoRepository<BlogPost, String> {

}
