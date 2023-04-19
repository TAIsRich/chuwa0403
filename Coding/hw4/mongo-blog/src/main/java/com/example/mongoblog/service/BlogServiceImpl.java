package com.example.mongoblog.service;

import com.example.mongoblog.entity.BlogEntity;
import com.example.mongoblog.pojo.Blog;
import com.example.mongoblog.repository.BlogRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService{
    private BlogRepository blogRepository;

    @Autowired
    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public Blog createBlog(Blog newBlog) {
        BlogEntity blogEntity = new BlogEntity();
        BeanUtils.copyProperties(newBlog, blogEntity);
        BlogEntity savedEntity = blogRepository.save(blogEntity);

        Blog blog = Blog.builder().id(savedEntity.getId()).name(savedEntity.getName()).author(savedEntity.getAuthor() ).build();
        return blog;
    }
}
