package com.example.post_pageable.dao;

import com.example.post_pageable.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
