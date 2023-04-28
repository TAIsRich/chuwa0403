package com.cassandra.cassandrablog.service.impl;

import com.cassandra.cassandrablog.dao.BlogRepository;
import com.cassandra.cassandrablog.entity.Blog;
import com.cassandra.cassandrablog.exception.ResourceNotFoundException;
import com.cassandra.cassandrablog.payLoad.BlogDto;
import com.cassandra.cassandrablog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogServiceImplement implements BlogService {
    @Autowired
    private BlogRepository blogRepository;
    @Override
    public BlogDto createBlog(BlogDto blogDto) {
       Blog blog = mapToEntity(blogDto);
        Blog savedBlog = blogRepository.save(blog);

        BlogDto blogResponse = mapToDto(savedBlog);
        return blogResponse;
    }

    @Override
    public List<BlogDto> getAllBlog() {
       List<Blog> blogs = blogRepository.findAll();
       List<BlogDto> blogDtos = blogs.stream().map(blog->mapToDto(blog)).collect(Collectors.toList());
       return blogDtos;
    }

    @Override
    public BlogDto getBlogById(long id) {
        Blog blog = blogRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Blog", "id", id));
        return mapToDto(blog);
    }

    @Override
    public BlogDto updateBlog(BlogDto blogDto, long id) {
        Blog blog = blogRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Blog", "id", id));
        blog.setTitle(blogDto.getTitle());
        blog.setDescription(blogDto.getDescription());
        blog.setContent(blogDto.getContent());

        Blog updateBlog = blogRepository.save(blog);
        return mapToDto(updateBlog);
    }

    @Override
    public void deleteBlogById(long id) {
        Blog blog = blogRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Blog", "id", id));
       blogRepository.delete(blog);

    }
    private Blog mapToEntity(BlogDto blogDto){
        Blog blog = new Blog();
        blog.setId(blogDto.getId());
        blog.setTitle(blogDto.getTitle());
        blog.setContent(blogDto.getContent());
        blog.setDescription(blogDto.getDescription());
        return blog;
    }
    private BlogDto mapToDto(Blog blog){
        BlogDto blogDto = new BlogDto();
        blogDto.setId(blog.getId());
        blogDto.setTitle(blog.getTitle());
        blogDto.setDescription(blog.getDescription());
        blogDto.setContent(blog.getContent());

        return blogDto;

    }
}
