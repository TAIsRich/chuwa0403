package com.example.cassandrablog.dao;

import com.example.cassandrablog.entity.BlogPost;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostRepository extends CassandraRepository<BlogPost, Long> {

}
