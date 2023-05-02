package com.richard.spring.service.impl;

import com.richard.spring.dao.PostRepository;
import com.richard.spring.entity.Post;
import com.richard.spring.exception.ResourceNotFoundException;
import com.richard.spring.payload.PostDto;
import com.richard.spring.payload.PostResponse;
import com.richard.spring.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author zhuhaotian
 * @Date 2023/4/28
 */

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public PostDto createPost(PostDto postDto) {
//        // 首先把payload转化成entity，这样才能用dao把数据存入数据库
//        Post post = new Post();
//        if (postDto.getTitle() != null) {
//            post.setTitle(postDto.getTitle());
//        } else {
//            post.setTitle("");
//        }
//        post.setContent(postDto.getContent());
//        post.setDescription(postDto.getDescription());
//        // 成功将payload 转化成 entity
//
//        // 调用dao的save方法，将entity存入数据库中
//        // save()会返回存储在数据库中的数据
//        Post savedPost = postRepository.save(post);
//
//        // 将save()返回的数据转换成controller需要的数据
//        // 然后return给controller
//        PostDto postResponse = new PostDto();
//        postResponse.setId(savedPost.getId());
//        postResponse.setTitle(savedPost.getTitle());
//        postResponse.setContent(savedPost.getContent());
//        postResponse.setDescription(savedPost.getDescription());
//
//        return postResponse;

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

    // 实现分页
    @Override
    public PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortBy).ascending() :
                Sort.by(sortBy).descending();

        // Create pageable instance
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize, sort);
        Page<Post> pagePosts = postRepository.findAll(pageRequest);

        // Get content from page objects
        List<Post> posts = pagePosts.getContent();
        // Or we can directly chain the above code into stream
        List<PostDto> postDTOs = pagePosts.getContent().stream()
                .map(PostServiceImpl::mapToDto)
                .toList();

        return new PostResponse(
                postDTOs,
                pagePosts.getNumber(),
                pagePosts.getSize(),
                pagePosts.getTotalPages(),
                pagePosts.getTotalElements(),
                pagePosts.isLast()
        );
    }

    @Override
    public PostDto getPostById(long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        return mapToDto(post);
    }

    @Override
    public PostDto updatePost(PostDto postDto, long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());

        Post updatedPost = postRepository.save(post);
        return mapToDto(updatedPost);
    }

    @Override
    public void deletePostById(long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

        postRepository.delete(post);
    }

    private static PostDto mapToDto(Post post) {
        PostDto ret = new PostDto();

        ret.setId(post.getId());
        ret.setTitle(post.getTitle());
        ret.setContent(post.getContent());
        ret.setDescription(post.getDescription());

        return ret;
    }

    private static Post mapToEntity(PostDto postDto) {
        Post ret = new Post();

        ret.setTitle(postDto.getTitle());
        ret.setContent(postDto.getContent());
        ret.setDescription(postDto.getDescription());

        return ret;
    }
}
