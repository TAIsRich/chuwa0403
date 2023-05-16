package com.richard.cookielearndarkui.service;

import com.richard.cookielearndarkui.payload.PostDto;
import com.richard.cookielearndarkui.payload.PostResponse;

/**
 * @Author zhuhaotian
 * @Date 2023/5/11
 */

public interface PostService {

    PostDto createPost(PostDto postDto);

    PostResponse getAllPost(int pageNo, int pageSize, String sortBy, String sortDie);

}
