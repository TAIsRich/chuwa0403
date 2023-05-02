package com.chuwa.jdbcTemplate.dao;

import com.chuwa.jdbcTemplate.entity.Post;

import java.util.List;

public interface PostDao {

    Post findById(Long id);

    List<Post> findAll();

    void save(Post post);

    void update(Post post);

    void deleteById(Long id);
}
