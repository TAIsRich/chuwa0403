package com.chuwa.cassandrablog.service;

import com.chuwa.cassandrablog.entity.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface BlogService {

    List<Blog> getUserByName(String name);
}
