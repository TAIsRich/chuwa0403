package com.cassandra.cassandrablog.dao;

import com.cassandra.cassandrablog.entity.Blog;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface BlogRepository extends CassandraRepository<Blog,Long> {
}
