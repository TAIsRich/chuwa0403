package com.chuwa.redbook.service;

import com.chuwa.redbook.payload.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PostService {

    PostDto createPost(PostDto postDto);

    List<PostDto> getAllPost();

    PostDto updatePost(PostDto postDto, long id);

    void deletePost(long id);
    //List<PostDto> getAllPost();

}
