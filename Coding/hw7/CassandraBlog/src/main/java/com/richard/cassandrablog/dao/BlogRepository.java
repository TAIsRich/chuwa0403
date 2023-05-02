package com.richard.cassandrablog.dao;

import com.richard.cassandrablog.entity.Blog;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends CassandraRepository<Blog, Long> {
}
