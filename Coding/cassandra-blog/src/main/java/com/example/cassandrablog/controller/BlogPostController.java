package com.example.cassandrablog.controller;

import com.example.cassandrablog.entity.BlogPost;
import com.example.cassandrablog.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogPostController {

    @Autowired
    private BlogPostService blogService;

    @GetMapping("/{id}")
    public ResponseEntity<BlogPost> getBlogById(@PathVariable long id) {
        BlogPost blog = blogService.getBlogById(id);
        return ResponseEntity.ok(blog);
    }

    @PostMapping("/")
    public ResponseEntity<BlogPost> createBlog(@RequestBody BlogPost blog) {
        BlogPost createdBlog = blogService.createBlog(blog);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBlog);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BlogPost> updateBlog(@PathVariable long id, @RequestBody BlogPost blog) {
        BlogPost updatedBlog = blogService.updateBlog(id, blog);
        return ResponseEntity.ok(updatedBlog);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlog(@PathVariable long id) {
        blogService.deleteBlog(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/")
    public ResponseEntity<List<BlogPost>> getAllBlogs() {
        List<BlogPost> blogs = blogService.getAllBlogs();
        return ResponseEntity.ok(blogs);
    }
}

