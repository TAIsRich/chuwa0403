package com.chuwa.redbook.service.impl;
import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.service.PostService;
import com.chuwa.redbook.entity.Post;

import java.util.List;

public class PostServiceImplmentation implements PostService {
    private PostRepository postRepository;
    public PostServiceImplmentation(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        Post newPost = postRepository.save(post);
        PostDto postResponse = new PostDto();
        postResponse.setId(newPost.getId());
        postResponse.setTitle(newPost.getTitle());
        postResponse.setDescription(newPost.getDescription());
        postResponse.setContent(newPost.getContent());
        return postResponse;
    }

    @Override
    public List<PostDto> getAllPost() {
        return null;
    }
}
