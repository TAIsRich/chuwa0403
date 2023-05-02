package com.cassandra.cassandrablog.controller;

import com.cassandra.cassandrablog.payLoad.BlogDto;
import com.cassandra.cassandrablog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @PostMapping
    public ResponseEntity<BlogDto> createPost(@RequestBody BlogDto blogDto) {
        BlogDto postResponse = blogService.createBlog(blogDto);
        return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
    }
    @GetMapping
    public List<BlogDto> getAllPosts() {
        return blogService.getAllBlog();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogDto> getPostById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(blogService.getBlogById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BlogDto> updatePostById(@RequestBody BlogDto blogDto, @PathVariable(name = "id") long id) {
        BlogDto blogResponse = blogService.updateBlog(blogDto, id);
        return new ResponseEntity<>(blogResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(name = "id") long id) {
        blogService.deleteBlogById(id);
        return new ResponseEntity<>("Blog entity deleted successfully.", HttpStatus.OK);
    }

}
