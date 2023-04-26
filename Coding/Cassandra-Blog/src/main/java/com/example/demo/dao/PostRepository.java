package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}