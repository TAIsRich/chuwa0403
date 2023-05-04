package com.chuwa.redbook.dao;

import com.chuwa.redbook.entity.Post;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PostJPQLRepository {
    List<Post> getAllPostWithJPQL();
}

