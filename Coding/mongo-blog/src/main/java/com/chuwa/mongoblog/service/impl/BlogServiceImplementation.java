package com.chuwa.mongoblog.service.impl;

import com.chuwa.mongoblog.dao.BlogRepository;
import com.chuwa.mongoblog.entity.Blog;
import com.chuwa.mongoblog.payload.BlogDto;
import com.chuwa.mongoblog.service.BlogService;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImplementation implements BlogService {

    private BlogRepository blogRepository;

    public BlogServiceImplementation(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }
    @Override
    public BlogDto createPost(BlogDto blogDto) {
        Blog post = mapToDocument(blogDto);

        Blog savedBlog = blogRepository.save(post);

        BlogDto blogResponse = mapToDTO(savedBlog);

        return blogResponse;
    }

    private BlogDto mapToDTO(Blog blog) {
        BlogDto blogDto = new BlogDto();
        blogDto.setId(blog.getId());
        blogDto.setTitle(blog.getTitle());
        blogDto.setDescription(blog.getDescription());
        blogDto.setContent(blog.getContent());

        return blogDto;
    }

    private Blog mapToDocument(BlogDto blogDto){
        Blog blog = new Blog();
        blog.setTitle(blogDto.getTitle());
        blog.setDescription(blogDto.getDescription());
        blog.setContent(blogDto.getContent());

        return blog;
    }
}
