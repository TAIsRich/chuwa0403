package com.chuwa.cassandrablog.service.impl;

import com.chuwa.cassandrablog.dao.BlogRepository;
import com.chuwa.cassandrablog.dto.BlogDto;
import com.chuwa.cassandrablog.entity.Blog;
import com.chuwa.cassandrablog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;

    public BlogDto createBlog(BlogDto blogDto) {
        Blog blog = new Blog(UUID.randomUUID(), blogDto.getMessage(), blogDto.getByName());
        Blog createBlog = blogRepository.save(blog);
        return mapToDto(createBlog);
    }

    public BlogDto findBlogById(UUID id) {
        Blog getBlog = blogRepository.findById(id).orElseThrow(() -> new RuntimeException("NO such element"));
        return mapToDto(getBlog);
    }

    private BlogDto mapToDto(Blog blog) {
        BlogDto blogDto = new BlogDto();
        blogDto.setId(blog.getId());
        blogDto.setMessage(blog.getMessage());
        blogDto.setByName(blog.getByName());

        return blogDto;
    }

    public BlogDto updatePost(BlogDto postDto, UUID id) {
        Blog getBlog = blogRepository.findById(id).orElseThrow(() -> new RuntimeException("NO such element"));
        getBlog.setByName(postDto.getByName());
        getBlog.setMessage(postDto.getMessage());
        Blog updateBlog = blogRepository.save(getBlog);

        return mapToDto(updateBlog);
    }

    public List<BlogDto> findAll() {
        return blogRepository.findAll().stream().map(blog -> mapToDto(blog)).collect(Collectors.toList());
    }

    public void deletePost(UUID id) {
        Blog getBlog = blogRepository.findById(id).orElseThrow(() -> new RuntimeException("NO such element"));
        blogRepository.delete(getBlog);
    }

//    private Blog mapToEntity(BlogDto commentDto) {
//        Blog comment = new Blog();
//        comment.setId(commentDto.getId());
//        comment.setName(commentDto.getName());
//        comment.setEmail(commentDto.getEmail());
//        comment.setBody(commentDto.getBody());
//
//        return comment;
//    }
}
