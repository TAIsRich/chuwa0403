package com.chuwa.cassandrablog.dao;

import com.chuwa.cassandrablog.entity.Blog;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface BlogRepository extends CassandraRepository<Blog, UUID> {
}