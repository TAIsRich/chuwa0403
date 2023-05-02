package com.chuwa.JPQL.dao.impl;

import com.chuwa.JPQL.dao.PostJPQLRepository;
import com.chuwa.JPQL.entity.Post;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class PostJPQLRepositoryImpl implements PostJPQLRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Post> getAllPostWithJPQL() {
        TypedQuery<Post> posts = entityManager.createNamedQuery("Post.getAll", Post.class);
        return posts.getResultList();
    }

    public Post insertPost(Post post) {
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
}
