package com.chuwa.cassandrablog.controller;

import com.chuwa.cassandrablog.dto.BlogDto;
import com.chuwa.cassandrablog.service.BlogService;
import com.chuwa.cassandrablog.service.impl.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping("")
    public ResponseEntity<BlogDto> createBlog(@RequestBody BlogDto blogDto) {
        BlogDto createBlogDto = blogService.createBlog(blogDto);
        return new ResponseEntity<>(createBlogDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogDto> getBlog(@PathVariable UUID id) {
        BlogDto returnBlogDto = blogService.findBlogById(id);
        return new ResponseEntity<>(returnBlogDto, HttpStatus.OK);
    }

    @GetMapping("")
    public List<BlogDto> getAllBlog() {
        List<BlogDto> returnBlogDto = blogService.findAll();
        return returnBlogDto;
    }

    @PutMapping("/{id}")
    public ResponseEntity<BlogDto> updatePostById(@RequestBody BlogDto postDto, @PathVariable(name = "id") UUID id) {
        BlogDto postResponse = blogService.updatePost(postDto, id);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePostById(@PathVariable(name = "id") UUID id) {
        blogService.deletePost(id);
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }
}