package com.chuwa.mongoblog.controller;

import com.chuwa.mongoblog.dao.BlogRepository;
import com.chuwa.mongoblog.payload.BlogDto;
import com.chuwa.mongoblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping
    public ResponseEntity<BlogDto> createPost(@RequestBody BlogDto blogDto) {
        return new ResponseEntity<>(blogService.createPost(blogDto), HttpStatus.CREATED);
    }
}
