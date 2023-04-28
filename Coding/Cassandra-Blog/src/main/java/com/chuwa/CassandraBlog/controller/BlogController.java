package com.chuwa.CassandraBlog.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.chuwa.CassandraBlog.entity.Blog;
import com.chuwa.CassandraBlog.service.BlogService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping
    public Mono<Blog> createBlog(@RequestBody Blog blog) {
        return blogService.createBlog(blog);
    }

    @GetMapping("/{id}")
    public Mono<Blog> getBlogById(@PathVariable UUID id) {
        return blogService.getBlogById(id);
    }

    @GetMapping
    public Flux<Blog> getAllBlogs() {
        return blogService.getAllBlogs();
    }

    @PutMapping
    public Mono<Blog> updateBlog(@RequestBody Blog blog) {
        return blogService.updateBlog(blog);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteBlogById(@PathVariable UUID id) {
        return blogService.deleteBlogById(id);
    }
}

