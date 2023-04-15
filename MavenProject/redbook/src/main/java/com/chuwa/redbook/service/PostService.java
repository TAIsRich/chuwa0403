package com.chuwa.redbook.service;

import com.chuwa.redbook.payload.PostDto;

import java.util.*;

public interface PostService {
    PostDto createPost(PostDto postDto);
    List<PostDto> getAllPost();
}
