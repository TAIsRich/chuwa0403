package com.chuwa.jdbcTemplate.service;

import com.chuwa.jdbcTemplate.dao.PostDao;
import com.chuwa.jdbcTemplate.entity.Post;
import org.springframework.stereotype.Service;

import java.util.List;


public class PostService {

    private PostDao postDao;

    public PostService(PostDao postDao) {
        this.postDao = postDao;
    }

    public Post findById(Long id) {
        return postDao.findById(id);
    }

    public List<Post> findAll() {
        return postDao.findAll();
    }

    public void save(Post post) {
        postDao.save(post);
    }

    public void update(Post post) {
        postDao.update(post);
    }

    public void deleteById(Long id) {
        postDao.deleteById(id);
    }
}
