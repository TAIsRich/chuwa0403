package com.richard.cassandrablog.service;

import com.richard.cassandrablog.entity.Blog;
import com.richard.cassandrablog.payload.BlogDto;

import java.util.List;

public interface BlogService {

    BlogDto createBlog(BlogDto blog);

    BlogDto getBlogById(Long id);

    BlogDto updateBlogById(BlogDto blogDto, long id);

    void deleteBlogById(Long id);
}
