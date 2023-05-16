package com.richard.cookielearndarkui.dao;

import com.richard.cookielearndarkui.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author zhuhaotian
 * @Date 2023/5/11
 */

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
