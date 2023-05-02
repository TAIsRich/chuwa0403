package com.chuwa.CassandraBlog.dao;

import com.chuwa.CassandraBlog.entity.Blog;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface BlogRepository extends CassandraRepository<Blog, UUID> {
}
