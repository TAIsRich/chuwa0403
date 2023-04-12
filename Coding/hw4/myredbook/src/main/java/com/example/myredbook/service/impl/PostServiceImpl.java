package com.example.myredbook.service.impl;

import com.example.myredbook.dao.PostRepository;
import com.example.myredbook.entity.Post;
import com.example.myredbook.payload.PostDto;
import com.example.myredbook.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public PostDto createPost(PostDto postDto) {

        // 先把Payload转换成Entity，这样dao才能把数据存入数据库中
        Post post = new Post();
        // 判断title是否为空，如果为空就创建一个新的title
        if (postDto.getTitle() != null) {
            post.setTitle(postDto.getTitle());
        } else {
            post.setTitle("");
        }
        // 创建其他的必须项
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        // 此时成功将request body的信息传递给了entity

        // 调用Dao的save方法，将entity的数据存储到数据库中
        // 同时这个方法会返回被存入数据库的数据
        Post savedPost = postRepository.save(post);

        // 将这个返回回来的数据转换成controller（或者是前端）需要的数据
        // 然后返回该数据给controller
        PostDto postResponse = new PostDto();
        postResponse.setId(savedPost.getId());
        postResponse.setTitle(savedPost.getTitle());
        postResponse.setDescription(savedPost.getDescription());
        postResponse.setContent(savedPost.getContent());

        return postResponse;
    }
}
