package com.richard.jpqllearn.dao;

import com.richard.jpqllearn.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostJPQLRepository {

    List<Post> getAllPostWithJPQL();

}
