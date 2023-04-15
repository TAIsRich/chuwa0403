package com.example.mongoblog.service.impl;

import com.example.mongoblog.model.BlogItem;
import com.example.mongoblog.payload.PostDto;
import com.example.mongoblog.repository.ItemRepository;
import com.example.mongoblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PostServiceImpl implements PostService {
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public BlogItem createPost(BlogItem blogItem) {
        // 把payload转换成entity，这样才能dao去把该数据存到数据库中。
//        Post post = new Post();
//        if (postDto.getTitle() != null) {
//            post.setTitle(postDto.getTitle());
//        } else {
//            post.setTitle("");
//        }
//        post.setDescription(postDto.getDescription());
//        post.setContent(postDto.getContent());
//        // 此时已成功把request body的信息传递给entity
//
//        // 调用Dao的save 方法，将entity的数据存储到数据库MySQL
//        // save()会返回存储在数据库中的数据
//        Post savedPost = postRepository.save(post);
//
//        // 将save() 返回的数据转换成controller/前端 需要的数据，然后return给controller
//        PostDto postResponse = new PostDto();
//        postResponse.setId(savedPost.getId());
//        postResponse.setTitle(savedPost.getTitle());
//        postResponse.setDescription(savedPost.getDescription());
//        postResponse.setContent(savedPost.getContent());
//
//        return postResponse;
        return itemRepository.save(blogItem);
    }
}
