package com.richard.jpqllearn.service;

import com.richard.jpqllearn.entity.Post;
import com.richard.jpqllearn.payload.PostDto;

import java.util.List;

/**
 * @Author zhuhaotian
 * @Date 2023/5/1
 */

public interface PostService {

    // POST
    PostDto createPost(PostDto postDto);

    // GET
    List<PostDto> getAllPosts();

    // GET
    PostDto getPostById(long id);

    // PUT
    PostDto updatePost(PostDto postDto, long id);

    // DELETE
    void deletePost(long id);


    List<PostDto> getAllPostsWithJPQL();
    PostDto getPostByIdJPQLIndexParameter(Long id, String title);
    PostDto getPostByIdJPQLNamedParameter(Long id, String title);
    PostDto getPostByIdSQLIndexParameter(Long id, String title);
    PostDto getPostByIdSQLNamedParameter(Long id, String title);

}
