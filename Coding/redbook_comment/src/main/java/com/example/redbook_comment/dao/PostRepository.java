package com.example.redbook_comment.dao;

import com.example.redbook_comment.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    Post findByTitle(String title);
    Post findByContent(String content);
}
