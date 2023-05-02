package com.cassandra.cassandrablog.service;

import com.cassandra.cassandrablog.entity.Blog;
import com.cassandra.cassandrablog.payLoad.BlogDto;

import java.util.List;

public interface BlogService {

    BlogDto createBlog(BlogDto blogDto);
    List<BlogDto> getAllBlog();

    BlogDto getBlogById(long id);
    BlogDto updateBlog(BlogDto blogDto,long id);
    void deleteBlogById(long id);


}
