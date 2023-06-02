package com.example.mongoblog.controller;

import com.example.mongoblog.model.BlogItem;
import com.example.mongoblog.payload.PostDto;
import com.example.mongoblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
//@RequestMapping("/api/v1")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/posts")
    public ResponseEntity<BlogItem> createPost(@RequestBody BlogItem blogItem) {
        BlogItem postResponse = postService.createPost(blogItem);
        return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
    }

}
