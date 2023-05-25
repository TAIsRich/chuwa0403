package com.chuwa.redbook.dao.JPQL;

import com.chuwa.redbook.entity.Post;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class PostRepoImpl implements PostRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Post> getAllPostWithJPQL() {
        TypedQuery<Post> posts = entityManager.createNamedQuery("Post.getAll", Post.class);
        return posts.getResultList();
    }

    public Post insertPost(Post post) {
        // post中可以無ID
        return entityManager.merge(post);
    }

    public Post updatePost(Post post) {
        // post中必须有id才行。
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
