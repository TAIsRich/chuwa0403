package com.example.mongoblog.controller;

import com.example.mongoblog.pojo.Blog;
import com.example.mongoblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blogs")
public class BlogController {
    private BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping
    public Blog createBlog(@Validated @RequestBody Blog newBlog) {
        Blog blog = blogService.createBlog(newBlog);

        return blog;
    }
}
