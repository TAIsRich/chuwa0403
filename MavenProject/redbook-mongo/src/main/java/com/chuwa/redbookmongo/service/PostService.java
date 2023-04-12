package com.chuwa.redbookmongo.service;

import com.chuwa.redbookmongo.payload.PostDTO;

public interface PostService {
    PostDTO createPost(PostDTO postDTO);
}
