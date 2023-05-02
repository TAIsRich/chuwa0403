package com.example.cassandrablog.service.impl;

import com.example.cassandrablog.entity.Blog;
import com.example.cassandrablog.pojo.BlogDto;
import com.example.cassandrablog.repository.BlogRepository;
import com.example.cassandrablog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService {
    private BlogRepository blogRepository;

    @Autowired
    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public BlogDto getBlogById(Long id) {
        Blog blog = blogRepository.findById(id).orElseThrow(() -> new RuntimeException("Not exist"));
        return mapToDTO(blog);
    }

    @Override
    public BlogDto createBlog(BlogDto blogDto) {
        Blog blog = mapToEntity(blogDto);
        Blog savedBlog = blogRepository.save(blog);

        return mapToDTO(savedBlog);
    }

    @Override
    public BlogDto updateBlog(BlogDto blogDto, long id) {
        Blog blog = blogRepository.findById(id).orElseThrow(() -> new RuntimeException("not exist"));
        blog.setTitle(blogDto.getTitle());
        blog.setAuthor(blogDto.getAuthor());
        Blog updatedBlog = blogRepository.save(blog);
        return mapToDTO(updatedBlog);
    }

    @Override
    public void deleteBlog(long id) {
        Blog blog = blogRepository.findById(id).orElseThrow(() -> new RuntimeException("not exist"));
        blogRepository.delete(blog);
    }

    private BlogDto mapToDTO(Blog blog) {
        BlogDto blogDto = new BlogDto();
        blogDto.setId(blog.getId());
        blogDto.setTitle(blog.getTitle());
        blogDto.setAuthor(blog.getAuthor());

        return blogDto;
    }

    private Blog mapToEntity(BlogDto blogDto) {
        Blog blog = new Blog();
        blog.setId(blogDto.getId());
        blog.setTitle(blogDto.getTitle());
        blog.setAuthor(blogDto.getAuthor());

        return blog;
    }
}
