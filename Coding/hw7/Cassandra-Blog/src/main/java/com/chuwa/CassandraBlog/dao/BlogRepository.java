package com.chuwa.CassandraBlog.dao;

import java.util.UUID;

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

import com.chuwa.CassandraBlog.entity.Blog;

@Repository
public interface BlogRepository extends ReactiveCassandraRepository<Blog, UUID> {
}