package com.example.cassandrablog.controller;

import com.example.cassandrablog.pojo.BlogDto;
import com.example.cassandrablog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blogs")
public class BlogController {
    private BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogDto> getBlogById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(blogService.getBlogById(id));
    }

    @PostMapping()
    public ResponseEntity<BlogDto> createBlog(@RequestBody BlogDto blogDto) {
        BlogDto blogResp = blogService.createBlog(blogDto);
        return new ResponseEntity<>(blogResp, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BlogDto> updateBlogById(@RequestBody BlogDto blogDto, @PathVariable(name = "id") long id) {
        BlogDto blogResp = blogService.updateBlog(blogDto, id);
        return new ResponseEntity<>(blogResp, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBlog(@PathVariable(name = "id") long id) {
        blogService.deleteBlog(id);
        return new ResponseEntity<>("Blog entity deleted successfully.", HttpStatus.OK);
    }



}
