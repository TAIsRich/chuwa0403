package com.richard.jpqllearn.service.impl;

import com.richard.jpqllearn.dao.PostJPQLRepository;
import com.richard.jpqllearn.dao.PostRepository;
import com.richard.jpqllearn.entity.Post;
import com.richard.jpqllearn.exception.ResourceNotFoundException;
import com.richard.jpqllearn.payload.PostDto;
import com.richard.jpqllearn.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author zhuhaotian
 * @Date 2023/5/1
 */

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    PostJPQLRepository postJPQLRepository;

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = mapToEntity(postDto);

        Post savedPost = postRepository.save(post);
        return mapToDto(savedPost);
    }

    @Override
    public List<PostDto> getAllPosts() {
        return postRepository.findAll().stream()
                .map(PostServiceImpl::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PostDto getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        return mapToDto(post);
    }

    @Override
    public PostDto updatePost(PostDto postDto, long id) {
        Post post = postRepository.findById(id).orElseThrow(ResourceNotFoundException::new);

        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        Post updatePost = postRepository.save(post);
        return mapToDto(post);
    }

    @Override
    public void deletePost(long id) {
        Post post = postRepository.findById(id).orElseThrow(RuntimeException::new);
        postRepository.delete(post);
    }

    @Override
    public List<PostDto> getAllPostsWithJPQL() {
        return postJPQLRepository.getAllPostWithJPQL().stream()
                .map(PostServiceImpl::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PostDto getPostByIdJPQLIndexParameter(Long id, String title) {
        return mapToDto(postRepository.getPostByIdOrTitleWithJPQLIndexParameters(id, title));
    }

    @Override
    public PostDto getPostByIdJPQLNamedParameter(Long id, String title) {
        return mapToDto(postRepository.getPostByIdOrTitleWithJPQLNamedParameters(id, title));
    }

    @Override
    public PostDto getPostByIdSQLIndexParameter(Long id, String title) {
        return mapToDto(postRepository.getPostByIdOrTitleWithSqlIndexParameters(id, title));
    }

    @Override
    public PostDto getPostByIdSQLNamedParameter(Long id, String title) {
        return mapToDto(postRepository.getPostByIdOrTitleWithSqlNamedParameters(id, title));
    }



    private static PostDto mapToDto(Post post) {
        PostDto dto = new PostDto();

        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setContent(post.getContent());
        dto.setDescription(post.getDescription());

        return dto;
    }

    private static Post mapToEntity(PostDto postDto) {
        Post post = new Post();

        post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());

        return post;
    }
}
