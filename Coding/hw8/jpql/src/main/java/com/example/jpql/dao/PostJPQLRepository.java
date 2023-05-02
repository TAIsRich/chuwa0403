package com.example.jpql.dao;

import com.example.jpql.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostJPQLRepository {
    List<Post> getAllPostWithJPQL();
}
