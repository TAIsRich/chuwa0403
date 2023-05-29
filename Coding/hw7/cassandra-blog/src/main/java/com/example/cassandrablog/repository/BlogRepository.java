package com.example.cassandrablog.repository;

import com.example.cassandrablog.entity.Blog;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface BlogRepository extends CassandraRepository<Blog, Long> {
}
