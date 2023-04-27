package com.example.cassandrablog.service;

import com.example.cassandrablog.dao.BlogPostRepository;
import com.example.cassandrablog.entity.BlogPost;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogPostService {

    @Autowired
    private BlogPostRepository blogPostRepository;

    public BlogPost getBlogById(Long id) {
        Optional<BlogPost> blog = blogPostRepository.findById(id);
        if(blog.isPresent()) {
            return blog.get();
        } else {
            throw new EntityNotFoundException("Blog not found with id " + id);
        }
    }

    public BlogPost createBlog(BlogPost blog) {
        return blogPostRepository.save(blog);
    }

    public BlogPost updateBlog(Long id, BlogPost blog) {
        BlogPost existingBlog = getBlogById(id);
        existingBlog.setTitle(blog.getTitle());
        existingBlog.setContent(blog.getContent());
        return blogPostRepository.save(existingBlog);
    }

    public void deleteBlog(Long id) {
        blogPostRepository.deleteById(id);
    }

    public List<BlogPost> getAllBlogs() {
        return (List<BlogPost>) blogPostRepository.findAll();
    }
}


