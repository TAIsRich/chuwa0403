package com.chuwa.casaandra;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    List<PostDto> getAllPost();
    PostDto getPostById(long id);
    PostDto updatePost(PostDto postDTO, long id);
    void deletePostById(long id);
}
