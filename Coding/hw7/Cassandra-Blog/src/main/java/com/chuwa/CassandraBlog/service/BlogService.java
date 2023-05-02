package com.chuwa.CassandraBlog.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chuwa.CassandraBlog.dao.BlogRepository;
import com.chuwa.CassandraBlog.entity.Blog;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public Mono<Blog> createBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    public Mono<Blog> getBlogById(UUID id) {
        return blogRepository.findById(id);
    }

    public Flux<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    public Mono<Blog> updateBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    public Mono<Void> deleteBlogById(UUID id) {
        return blogRepository.deleteById(id);
    }
}
