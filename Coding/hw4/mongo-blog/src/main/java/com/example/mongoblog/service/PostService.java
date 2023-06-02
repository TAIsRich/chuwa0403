package com.example.mongoblog.service;

import com.example.mongoblog.model.BlogItem;
import com.example.mongoblog.payload.PostDto;

public interface PostService {

    BlogItem createPost(BlogItem postDto);
}
