package com.chuwa.redbook.controller;

import com.chuwa.redbook.entity.Comment;
import com.chuwa.redbook.payload.CommentDto;
import com.chuwa.redbook.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto,
                                                    @PathVariable(value = "postId") long postId) {
        CommentDto commentResponse = commentService.createComment(postId, commentDto);
        return new ResponseEntity<>(commentResponse, HttpStatus.ACCEPTED);
    }

    @GetMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable(value = "id") long id,
                                                     @PathVariable(value = "postId") long postId) {
        CommentDto commentResponse = commentService.getCommentById(postId, id);
        return new ResponseEntity<>(commentResponse, HttpStatus.OK);
    }

    @GetMapping("/posts/{postId}/comments")
    public List<CommentDto> getCommentsByPostId(@PathVariable(value = "postId") long postId) {
        return commentService.getCommentsByPostId(postId);
    }

    @PutMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<CommentDto> updateCommentById(@PathVariable(value = "id") long id,
                                                        @PathVariable(value = "postId") long postId,
                                                        @RequestBody CommentDto commentDto) {
        CommentDto commentResponse = commentService.updateComment(postId, id, commentDto);
        return new ResponseEntity<>(commentResponse, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable(value = "postId") Long postId,
                                                @PathVariable(value = "id") Long commentId) {
        commentService.deleteComment(postId, commentId);

        return new ResponseEntity<>("Comment deleted Successfully", HttpStatus.OK);
    }

}
