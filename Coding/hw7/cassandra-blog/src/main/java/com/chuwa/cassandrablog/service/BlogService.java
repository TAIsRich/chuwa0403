package com.chuwa.cassandrablog.service;

import com.chuwa.cassandrablog.dto.BlogDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


public interface BlogService {
    public BlogDto createBlog(BlogDto blogDto);
    public BlogDto findBlogById(UUID id);
    public List<BlogDto> findAll();
    public void deletePost(UUID id);
    public BlogDto updatePost(BlogDto postDto, UUID id);
}
