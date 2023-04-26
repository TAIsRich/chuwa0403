package com.chuwa.casaandra;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CassandraRepository<Post,Long> {

}
