package com.example.comment.dao;

import com.example.comment.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author b1go
 * @date 8/22/22 6:48 PM
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    // No need to write code
    Post findByTitle(String title) throws RuntimeException;
}
