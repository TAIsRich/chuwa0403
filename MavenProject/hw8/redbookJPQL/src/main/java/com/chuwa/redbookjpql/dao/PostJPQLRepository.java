package com.chuwa.redbookjpql.dao;

import com.chuwa.redbookjpql.entity.Post;

import java.util.List;

public interface PostJPQLRepository {
    List<Post> getAllPostWithJPQL();
}
