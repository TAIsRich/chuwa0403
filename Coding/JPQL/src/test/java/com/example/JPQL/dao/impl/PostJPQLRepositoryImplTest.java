package com.example.JPQL.dao.impl;

import com.example.JPQL.entity.Post;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class PostJPQLRepositoryImplTest {

    @Autowired
    private PostJPQLRepositoryImpl repository;

    private Post post = new Post(null, "title test", "description test", "content test", null, null);

    @Test
    void getAllPostWithJPQL(){
        List<Post> posts = repository.getAllPostWithJPQL();
        System.out.println(posts);
    }

    @Test
    void insertPost(){
        post.setTitle(post.getTitle() + LocalDateTime.now());
        Post savedPost = repository.insertPost(post);
        System.out.println(savedPost);
    }

    @Test
    void updatePost(){
        post.setId(12L);
        post.setTitle(post.getTitle() + LocalDateTime.now());
        Post savedPost = repository.insertPost(post);
        System.out.println(savedPost);
    }
    @Test
    void getPostById() {
        Post postById = repository.getPostById(12L);
        System.out.println(postById);
    }

    @Test
    void deleteById() {
        post.setTitle(post.getTitle() + LocalDateTime.now());
        Post savedPost = repository.insertPost(post);
        System.out.println(savedPost);
        Long id = savedPost.getId();
        repository.deleteById(id);
        Post postById = repository.getPostById(id);
        System.out.println(postById);
    }

    @Test
    void insertData() {
        post.setTitle(post.getTitle() + LocalDateTime.now());
        Post savedPost = repository.insertData(post);
        System.out.println(savedPost);
    }

    //sessionFactory
    @Test
    void testSessionFactory(){
        //1.根据配置文件,创建一个sessionFactory
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        //2. sessionFactory 创建一个session
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try{
            //3. session 开始一个transaction
            transaction = session.beginTransaction();

            //4. 执行txn
            post.setTitle(post.getTitle() + LocalDateTime.now());
            post.setCreateDateTime(LocalDateTime.now());
            post.setUpdateDateTime(LocalDateTime.now());
            Post savedPost = (Post) session.merge(post);
            System.out.println(savedPost);
            //5. commit txn
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                // txn失败则回滚
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            // close session
            session.close();
        }



    }


}
