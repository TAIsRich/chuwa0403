package com.chuwa.redbookmongo.controller;

import com.chuwa.redbookmongo.payload.PostDTO;
import com.chuwa.redbookmongo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/posts")
public class PostControler {
    private final PostService postService;

    @Autowired
    public PostControler(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO) {
        PostDTO responseDTO = postService.createPost(postDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
}