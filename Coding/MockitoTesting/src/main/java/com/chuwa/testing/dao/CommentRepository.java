package com.chuwa.testing.dao;

import com.chuwa.testing.entity.Comment;
import com.chuwa.testing.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByPostId(long postId);

    Long countCommentsByPostIs(Post post);
}
