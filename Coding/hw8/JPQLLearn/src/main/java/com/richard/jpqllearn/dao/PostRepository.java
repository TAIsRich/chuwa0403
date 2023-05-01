package com.richard.jpqllearn.dao;

import com.richard.jpqllearn.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("select p from Post p where p.id = ?1 or p.title = ?2")
    Post getPostByIdOrTitleWithJPQLIndexParameters(long id, String title);

    @Query("select p from Post p where p.id = :key or p.title = :title")
    Post getPostByIdOrTitleWithJPQLNamedParameters(@Param("key") long id,
                                                   @Param("title") String title);

    @Query(value = "select * from posts p where p.id = ?1 or p.title = ?2", nativeQuery = true)
    Post getPostByIdOrTitleWithSqlIndexParameters(long id, String title);

    @Query(value = "select * from posts p where p.id = :key or p.title = :title", nativeQuery = true)
    Post getPostByIdOrTitleWithSqlNamedParameters(@Param("key") long id,
                                                  @Param("title") String title);
}
