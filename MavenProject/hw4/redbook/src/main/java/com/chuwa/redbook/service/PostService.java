package com.chuwa.redbook.service;

import com.chuwa.redbook.payload.PostDto;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto post);
    List<PostDto> getAllPost();

    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);

    void deletePostById(long id);

}
