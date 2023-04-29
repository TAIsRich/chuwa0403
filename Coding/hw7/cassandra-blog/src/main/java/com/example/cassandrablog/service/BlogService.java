package com.example.cassandrablog.service;

import com.example.cassandrablog.pojo.BlogDto;

public interface BlogService {
    BlogDto getBlogById(Long id);
    BlogDto createBlog(BlogDto blogDto);
    BlogDto updateBlog(BlogDto blogDto, long id);
    void deleteBlog(long id);
}
