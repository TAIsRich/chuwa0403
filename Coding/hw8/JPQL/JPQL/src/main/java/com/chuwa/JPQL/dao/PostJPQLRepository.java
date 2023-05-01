package com.chuwa.JPQL.dao;

import com.chuwa.JPQL.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostJPQLRepository {
    List<Post> getAllPostWithJPQL();
}
