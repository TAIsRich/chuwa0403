package com.chuwa.cassandrablog.dao;

import com.chuwa.cassandrablog.entity.Blog;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends CassandraRepository<Blog, String> {
    @Query(value = "select id, name, age from user where name = ?0 ALLOW filtering")
    List<Blog> findByName(String name);
}
