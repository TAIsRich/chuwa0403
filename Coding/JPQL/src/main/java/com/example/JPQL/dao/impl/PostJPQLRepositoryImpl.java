package com.example.JPQL.dao.impl;

import com.example.JPQL.dao.PostJPQLRepository;
import com.example.JPQL.entity.Post;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    //entityManager
    //1. Insert Update: entityManager.merge()
    //2. Select: entityManager.find();
    //3. delete: entityManager.remove();

    public Post insertPost(Post post){
        //post可以没有id
        return entityManager.merge(post);
    }

    public Post updatePost(Post post){
        //post中必须有id
        return entityManager.merge(post);
    }

    public Post getPostById(Long id){
        return entityManager.find(Post.class, id);
    }

    public void deleteById(Long id){
        Post post = entityManager.find(Post.class, id);
        entityManager.remove(post);
    }

    public <T> T insertData(T t){
        return entityManager.merge(t);
    }
}
