package com.richard.spring.service;

import com.richard.spring.payload.PostDto;
import com.richard.spring.payload.PostResponse;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto);

    List<PostDto> getAllPosts();

    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDie);

    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);

    void deletePostById(long id);
}
