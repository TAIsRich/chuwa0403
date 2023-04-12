package com.mangodb.mangoblog.controller;

import com.mangodb.mangoblog.Model.BlogPost;
import com.mangodb.mangoblog.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mangodb.mangoblog.repository.BlogPostRepository;

@RestController
@RequestMapping("api/v1/posts")
public class PostController {

    @Autowired
    private BlogPostRepository blogPostRepository;


    @PostMapping
    public ResponseEntity<BlogPost> createPost(@RequestBody BlogPost blogPost) {
        BlogPost postResponse = PostService.createPost(blogPost);
        return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
    }
}
