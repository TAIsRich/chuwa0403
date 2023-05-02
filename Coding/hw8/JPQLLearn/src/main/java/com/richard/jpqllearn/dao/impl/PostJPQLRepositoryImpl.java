package com.richard.jpqllearn.dao.impl;

import com.richard.jpqllearn.dao.PostJPQLRepository;
import com.richard.jpqllearn.entity.Post;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @Author zhuhaotian
 * @Date 2023/5/1
 */

@Repository
@Transactional
public class PostJPQLRepositoryImpl implements PostJPQLRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Post> getAllPostWithJPQL() {
        TypedQuery<Post> posts = entityManager.createNamedQuery("Post.getAll", Post.class);
        return posts.getResultList();
    }

    /**
     * Entity Manager:
     * 1. Insert Update: entityManager.merge()
     * 2. Select: entityManager.find()
     * 3. Delete: entityManager.remove()
     */
    public Post insertPost(Post post) {
        // post can have no id
        return entityManager.merge(post);
    }

    public Post updatePost(Post post) {
        return entityManager.merge(post);
    }

    public Post getPostById(Long id) {
        return entityManager.find(Post.class, id);
    }

    public void deleteById(Long id) {
        Post post = entityManager.find(Post.class, id);
        entityManager.remove(post);
    }

    public <T> T insertData(T t) {
        return entityManager.merge(t);
    }

}
