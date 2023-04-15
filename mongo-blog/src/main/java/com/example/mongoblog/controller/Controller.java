package com.example.mongoblog.controller;

import com.example.mongoblog.model.BlogPost;
import com.example.mongoblog.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class Controller {
    @Autowired
    private BlogPostRepository blogPostRepository;

    @PostMapping
    public ResponseEntity<?> createBlogPost(@RequestBody BlogPost blogPost) {
        blogPostRepository.save(blogPost);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
