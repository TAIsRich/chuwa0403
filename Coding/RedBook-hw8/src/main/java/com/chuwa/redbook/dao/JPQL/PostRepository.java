package com.chuwa.redbook.dao.JPQL;

import com.chuwa.redbook.entity.Post;
import java.util.List;

public interface PostRepository {
    List<Post> getAllPostWithJPQL();
}
