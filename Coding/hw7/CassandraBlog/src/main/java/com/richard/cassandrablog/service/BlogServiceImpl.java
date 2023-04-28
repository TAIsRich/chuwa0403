package com.richard.cassandrablog.service;

import com.richard.cassandrablog.dao.BlogRepository;
import com.richard.cassandrablog.entity.Blog;
import com.richard.cassandrablog.payload.BlogDto;
import org.springframework.stereotype.Service;

/**
 * @Author zhuhaotian
 * @Date 2023/4/28
 */

@Service
public class BlogServiceImpl implements BlogService {

    private BlogRepository blogRepository;

    @Override
    public BlogDto createBlog(BlogDto blogDto) {
        Blog blog = mapToEntity(blogDto);
        Blog savedBlog = blogRepository.save(blog);

        return mapToDTO(savedBlog);
    }

    @Override
    public BlogDto getBlogById(Long id) {
        Blog blog = blogRepository.findById(id).orElseThrow(() -> new RuntimeException("This id doesn't exist"));
        return mapToDTO(blog);
    }

    @Override
    public BlogDto updateBlogById(BlogDto blogDto, long id) {
        Blog blog = blogRepository.findById(id).orElseThrow(() -> new RuntimeException("This id doesn't exist"));

        blog.setTitle(blogDto.getTitle());
        blog.setAuthor(blogDto.getAuthor());
        blog.setContent(blog.getContent());

        Blog savedBlog = blogRepository.save(blog);
        return mapToDTO(savedBlog);
    }

    @Override
    public void deleteBlogById(Long id) {
        Blog blog = blogRepository.findById(id).orElseThrow(() -> new RuntimeException("This id doesn't exist"));

        blogRepository.delete(blog);
    }

    private BlogDto mapToDTO(Blog blog) {
        BlogDto ret = new BlogDto();

        ret.setId(blog.getId());
        ret.setAuthor(blog.getAuthor());
        ret.setContent(blog.getContent());

        return ret;
    }

    private Blog mapToEntity(BlogDto blogDto) {
        Blog ret = new Blog();

        ret.setId(blogDto.getId());
        ret.setTitle(blogDto.getTitle());
        ret.setAuthor(blogDto.getAuthor());

        return ret;
    }
}
