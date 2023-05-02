package com.richard.cassandrablog.controller;

import com.richard.cassandrablog.payload.BlogDto;
import com.richard.cassandrablog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Author zhuhaotian
 * @Date 2023/4/28
 */

@RestController
@RequestMapping("/blog/test")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping
    public ResponseEntity<BlogDto> createBlog(@RequestBody BlogDto blogDto) {
        BlogDto blogResponse = blogService.createBlog(blogDto);
        return new ResponseEntity<>(blogResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<BlogDto> getBlogById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(blogService.getBlogById(id));
    }

    @PutMapping
    public ResponseEntity<BlogDto> updateBlogById(@RequestBody BlogDto blogDto, @PathVariable(name = "id") long id) {
        BlogDto blogResponse = blogService.updateBlogById(blogDto, id);
        return new ResponseEntity<>(blogResponse, HttpStatus.OK);
    }

    @DeleteMapping
    public void deleteBlogById(@PathVariable(name = "id") long id) {
        blogService.deleteBlogById(id);
    }
}
