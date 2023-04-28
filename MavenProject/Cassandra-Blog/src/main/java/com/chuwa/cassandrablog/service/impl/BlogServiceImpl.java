package com.chuwa.cassandrablog.service.impl;

import com.chuwa.cassandrablog.dao.BlogRepository;
import com.chuwa.cassandrablog.entity.Blog;
import com.chuwa.cassandrablog.service.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BlogServiceImpl implements BlogService {
    final BlogRepository blogMapper;
    @Override
    public List<Blog> getUserByName(String name){
        return blogMapper.findByName(name);
    }
}
