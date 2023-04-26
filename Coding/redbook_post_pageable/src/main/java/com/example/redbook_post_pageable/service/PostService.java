package com.example.redbook_post_pageable.service;

import com.example.redbook_post_pageable.payload.PostDto;
import com.example.redbook_post_pageable.payload.PostResponse;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto);

    List<PostDto> getAllPost();

    PostResponse getAllPost(int pageNo, int pageSize, String sortBy, String sortDir);
    PostDto getPostById(long id);
    PostDto updatePost(PostDto postDto, long id);
    void deletePostById(long id);

}
