package com.example.comment.dao;

import com.example.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(long postId);
    Comment findByNameIgnoreCase(String name);
}
