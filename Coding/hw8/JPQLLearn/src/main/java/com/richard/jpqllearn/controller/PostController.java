package com.richard.jpqllearn.controller;

import com.richard.jpqllearn.entity.Post;
import com.richard.jpqllearn.payload.PostDto;
import com.richard.jpqllearn.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author zhuhaotian
 * @Date 2023/5/1
 */

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        PostDto postResponse = postService.createPost(postDto);
        return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public List<PostDto> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,
                                              @PathVariable(name = "id") long id) {
        PostDto postResponse = postService.updatePost(postDto, id);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(name = "id") long id) {
        postService.deletePost(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
