package com.example.JPQL.dao;

import com.example.JPQL.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostJPQLRepository {

    List<Post> getAllPostWithJPQL();
}
