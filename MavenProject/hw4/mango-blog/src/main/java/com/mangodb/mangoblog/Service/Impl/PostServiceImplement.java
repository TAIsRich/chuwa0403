package com.mangodb.mangoblog.Service.Impl;

import com.mangodb.mangoblog.Model.BlogPost;
import com.mangodb.mangoblog.Service.PostService;
import com.mangodb.mangoblog.repository.BlogPostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImplement implements PostService {
    private BlogPostRepository blogPostRepository;

    public PostServiceImplement(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }

    @Override
    public BlogPost creatPost(BlogPost post) {
        return  blogPostRepository.save(post);
    }
}
